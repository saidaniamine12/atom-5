package net.thevpc.gaming.atom.examples.kombla.main.server.dao;


import net.thevpc.gaming.atom.examples.kombla.main.client.models.DynamicGameModel;
import net.thevpc.gaming.atom.examples.kombla.main.client.models.Player;
import net.thevpc.gaming.atom.examples.kombla.main.client.models.Sprite;
import net.thevpc.gaming.atom.examples.kombla.main.client.models.StartGameInfo;
import net.thevpc.gaming.atom.examples.kombla.main.client.models.enums.ProtocolConstants;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketMainServerDAO implements MainServerDAO{

    private  ServerSocket serverSocket;

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private final static int port = 4444;
    private Map<Integer,ClientSession> playerToSocketMap = new HashMap<>();

    public SocketMainServerDAO() {
    }
    @Override
    public void start() {
        try {
            this.serverSocket = new ServerSocket();

            while (true){
                Socket clientSocket = serverSocket.accept();

                this.objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
                this.objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

                Integer playerId = objectInputStream.readInt();
                ClientSession clientSession = new ClientSession(clientSocket,objectInputStream,objectOutputStream,playerId);
                playerToSocketMap.put(playerId,clientSession);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Runnable runnable = () -> processClient(clientSession);
                    }
                });
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void processClient(ClientSession clientSession) {
        try {
            ProtocolConstants isConnect = (ProtocolConstants) this.objectInputStream.readObject();
            if (isConnect == ProtocolConstants.CONNECT) {
                System.out.println("Client connected");
                StartGameInfo startGameInfo = new StartGameInfo();
                Player player = (Player) this.objectInputStream.readObject();
                this.objectOutputStream.writeObject(startGameInfo);
                playerToSocketMap.put(player.getId(),clientSession);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeStartGameInfo(StartGameInfo startGameInfo)  {
        try {
            this.objectOutputStream.writeObject(startGameInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sendMoveLeft() throws IOException {
        ProtocolConstants left = ProtocolConstants.LEFT;
        this.objectOutputStream.write(left.getValue());
        this.objectOutputStream.flush();
    }

    @Override
    public void sendMoveRight() throws IOException {
        ProtocolConstants right = ProtocolConstants.RIGHT;
        this.objectOutputStream.write(right.getValue());
        this.objectOutputStream.flush();
    }

    @Override
    public void sendMoveUp() throws IOException {
        ProtocolConstants up = ProtocolConstants.UP;
        this.objectOutputStream.write(up.getValue());
        this.objectOutputStream.flush();
    }

    @Override
    public void sendMoveDown() throws IOException {
        ProtocolConstants down = ProtocolConstants.DOWN;
        this.objectOutputStream.write(down.getValue());
        this.objectOutputStream.flush();
    }

    @Override
    public void sendBomb() throws IOException {
        ProtocolConstants bomb = ProtocolConstants.BOMB;
        this.objectOutputStream.write(bomb.getValue());
        this.objectOutputStream.flush();
    }

    @Override
    public void sendOk() throws IOException {
        ProtocolConstants ok = ProtocolConstants.OK;
        this.objectOutputStream.write(ok.getValue());
        this.objectOutputStream.flush();
    }

    @Override
    public void sendKo() throws IOException {
        ProtocolConstants ko = ProtocolConstants.KO;
        this.objectOutputStream.write(ko.getValue());
        this.objectOutputStream.flush();
    }

    @Override
    public void writePlayer(Player player) throws IOException {
        this.objectOutputStream.writeObject(player);
        this.objectOutputStream.flush();
    }

    @Override
    public void writeSprite(Sprite sprite) throws IOException {
        this.objectOutputStream.writeObject(sprite);
        this.objectOutputStream.flush();
    }

    public void sendModelChanged(DynamicGameModel dynamicGameModel) throws IOException {
        this.objectOutputStream.writeObject(dynamicGameModel);
        this.objectOutputStream.flush();
    }


    public class ClientSession {
        private Socket clientSocket;
        private ObjectInputStream objectInputStream;
        private ObjectOutputStream objectOutputStream;
        private Integer playerId;
        public ClientSession() {
        }
        public ClientSession(Socket clientSocket, ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream, Integer playerId) {
            this.clientSocket = clientSocket;
            this.objectInputStream = objectInputStream;
            this.objectOutputStream = objectOutputStream;
            this.playerId = playerId;
        }
    }





}

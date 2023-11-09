package net.thevpc.gaming.atom.examples.kombla.main.client.dao;

import net.thevpc.gaming.atom.examples.kombla.main.client.models.StartGameInfo;
import net.thevpc.gaming.atom.examples.kombla.main.client.models.enums.ProtocolConstants;
import net.thevpc.gaming.atom.examples.kombla.main.client.models.enums.SocketType;
import net.thevpc.gaming.atom.examples.kombla.main.client.services.StartGameInfoReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class SocketMainClientDAO implements MainClientDAO {


    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private ByteArrayOutputStream byteArrayOutputStream;


    public SocketMainClientDAO() {
        this.socket = null;
        this.objectInputStream = null;
        this.objectOutputStream = null;
        this.byteArrayOutputStream = null;
    }

    public void start(String serverAddress,Integer port) {
        try {
            //create socket and connect to server
            this.socket = new Socket(serverAddress,port);

            //create the input and output streams for communication
            this.objectInputStream = new ObjectInputStream(socket.getInputStream());
            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            onLoopReceiveModelChanged();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void onLoopReceiveModelChanged() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // Continuously listen for changes
                    StartGameInfo startGameInfo = connect(SocketType.TCP);
                    if (startGameInfo != null) {
                        System.out.println("Received StartGameInfo: " + startGameInfo);
                    }
                }
            }
        });
        thread.start();
    }

    @Override
    public StartGameInfo connect(SocketType socketType) {
        StartGameInfo startGameInfo = null;
        try {
            startGameInfo = StartGameInfoReader.readStartGameInfo(this.objectInputStream);
            switch (socketType){
                case TCP:
                    this.objectOutputStream.writeObject(startGameInfo);
                    this.objectOutputStream.flush();
                    break;
                case UDP:
                    this.byteArrayOutputStream = new ByteArrayOutputStream();
                    String  message ="Hello from client";
                    this.byteArrayOutputStream.write(message.getBytes());
                    byte[] data = byteArrayOutputStream.toByteArray();
                    this.objectOutputStream.write(data);
                    this.objectOutputStream.flush();
                    break;
                case UDP_MULTICAST:
                    try {
                        DatagramSocket udpMultiSocket = new DatagramSocket();
                        Inet4Address inet4Address = (Inet4Address) Inet4Address.getByName("172.0.0.1");
                        MulticastSocket multicastSocket = new MulticastSocket();
                        String  message1 ="Hello from client";
                        DatagramPacket datagramPacket = new DatagramPacket(message1.getBytes(), message1.length(), inet4Address, 4446);

                        System.out.println("Sending: " + message1);
                        udpMultiSocket.send(datagramPacket);
                        //closing the socket
                        multicastSocket.close();
                    } catch (IOException| SecurityException e) {
                        e.printStackTrace();
                    }


                    break;
            }


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return startGameInfo;
    }

    @Override
    public void sendMoveLeft() throws IOException {
        ProtocolConstants left = ProtocolConstants.LEFT;
        this.objectOutputStream.write(left.getValue());
        this.objectOutputStream.flush();
    }


    public void close() {
        try {
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package net.thevpc.gaming.atom.examples.kombla.main.client.dao;


import net.thevpc.gaming.atom.examples.kombla.main.client.models.StartGameInfo;
import net.thevpc.gaming.atom.examples.kombla.main.client.models.enums.SocketType;

import java.io.IOException;

public interface MainClientDAO {

    //creat socket and wait for client connection
    void start(String serverAddress,Integer port);

    //read from client and convert to string
    void onLoopReceiveModelChanged();

    StartGameInfo connect(SocketType socketType);

    // send MoveLEFT to server
    void sendMoveLeft() throws IOException;

    //connection close
    void close();
}

package net.thevpc.gaming.atom.examples.kombla.main.server.dao;



import net.thevpc.gaming.atom.examples.kombla.main.client.models.Player;
import net.thevpc.gaming.atom.examples.kombla.main.client.models.Sprite;
import net.thevpc.gaming.atom.examples.kombla.main.client.models.StartGameInfo;

import java.io.IOException;

public interface MainServerDAO {

    void start() throws IOException;

    void processClient(SocketMainServerDAO.ClientSession clientSession);

    void writeStartGameInfo(StartGameInfo startGameInfo);

    void sendMoveLeft() throws IOException;

    void sendMoveRight() throws IOException;

    void sendMoveUp() throws IOException;

    void sendMoveDown() throws IOException;

    void sendBomb() throws IOException;

    void sendOk() throws IOException;

    void sendKo() throws IOException;

    void writePlayer(Player player) throws IOException;

    void writeSprite(Sprite sprite) throws IOException;
}

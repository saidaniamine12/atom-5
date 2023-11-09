package net.thevpc.gaming.atom.examples.kombla.main.server.models;

import java.io.Serializable;
import java.util.List;

public class StartGameInfo implements Serializable {

    private Integer playerNumber;

    private Long playerId;
    private List<List<Character>> labyrinth;

    public StartGameInfo() {
    }


    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public List<List<Character>> getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(List<List<Character>> labyrinth) {
        this.labyrinth = labyrinth;
    }
}

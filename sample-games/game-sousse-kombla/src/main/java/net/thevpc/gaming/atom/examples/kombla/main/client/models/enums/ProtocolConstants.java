package net.thevpc.gaming.atom.examples.kombla.main.client.models.enums;

public enum ProtocolConstants {
    LEFT(1),
    RIGHT(2),
    UP(3),
    DOWN(4),
    BOMB(5),

    OK(6),

    KO(7),

    CONNECT(8);


    private final int value;

    ProtocolConstants( int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

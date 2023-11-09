package net.thevpc.gaming.atom.examples.kombla.main.client.models;

import java.util.Map;

public class DefaultPlayer {

    private Integer id;
    private String name;

    private Map<String,String> properties;

    public DefaultPlayer() {
    }

    public DefaultPlayer(Integer id, String name, Map<String, String> properties) {
        this.id = id;
        this.name = name;
        this.properties = properties;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

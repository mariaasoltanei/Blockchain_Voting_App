package com.example.blockchain_voting_app.models;

public class DummyVotingSession {
    private String name;
    private String description;
    private int options;

    public DummyVotingSession(String name, String description, int options) {
        this.name = name;
        this.description = description;
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOptions() {
        return options;
    }

    public void setOptions(int options) {
        this.options = options;
    }
}

package com.example.blockchain_voting_app.models;

import java.util.ArrayList;

public class DummyVotingSession {
    private String name;
    private String description;
    private ArrayList<String> options;
    private String imgSource;

    public DummyVotingSession(String name, String description, ArrayList<String> options, String imgSource) {
        this.name = name;
        this.description = description;
        this.options = options;
        this.imgSource = imgSource;
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

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
}

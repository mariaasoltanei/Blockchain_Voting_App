package com.example.blockchain_voting_app.models;

import java.util.Arrays;

public class VotingSession {
    private String name;
    private String description;
    private String[] options;
    private int[] votes;
    private User[] usersVoted;

    public VotingSession(String name, String description, String[] options, int[] votes, User[] usersVoted) {
        this.name = name;
        this.description = description;
        this.options = options;
        this.votes = votes;
        this.usersVoted = usersVoted;
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

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int[] getVotes() {
        return votes;
    }

    public void setVotes(int[] votes) {
        this.votes = votes;
    }

    public User[] getUsersVoted() {
        return usersVoted;
    }

    public void setUsersVoted(User[] usersVoted) {
        this.usersVoted = usersVoted;
    }

    @Override
    public String toString() {
        return "VotingSession{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", options=" + Arrays.toString(options) +
                ", votes=" + Arrays.toString(votes) +
                ", usersVoted=" + Arrays.toString(usersVoted) +
                '}';
    }
}

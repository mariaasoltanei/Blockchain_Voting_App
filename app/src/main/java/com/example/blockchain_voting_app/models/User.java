package com.example.blockchain_voting_app.models;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String cnp;
    private String password;
    private boolean hasVoted;

    public User(String id, String firstName, String lastName, String cnp, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.password = password;
        //this.hasVoted = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}

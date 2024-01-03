package com.example.blockchain_voting_app.models;

public class User {
    private String firstName;
    private String lastName;
    private String cnp;
    private String password;

    public User(String firstName, String lastName, String cnp, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.password = password;
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
}

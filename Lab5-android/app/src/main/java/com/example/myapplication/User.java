package com.example.myapplication;

public class User {
    private String username;
    private String fullname;
    private String email;
    int a;



    public User(String username, String fullname, String email, int a) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.a=a;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

package com.example.android_job_project.offlinestorage;

/**
 * Created by Dell on 30-04-2018.
 */

public class User {
    private int id;
    private String Username;
    private String Password;

    @Override
    public String toString() {
        return "User{" +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

package br.eng.eaa.application.model;

import java.util.UUID;

public class UserRequest {

    private UUID id;
    private String name;
    private String password;

    public UserRequest(String name, String password){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty or null");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is empty or null");
        }
        this.name = name;
        this.password = password;
    }

    public UserRequest(UUID id, String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}

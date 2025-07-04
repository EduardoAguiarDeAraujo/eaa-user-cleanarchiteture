package br.eng.eaa.application.model;

import java.util.UUID;

public class UserRequest {

    private UUID id;
    private String name;
    private String password;

    public UserRequest(String name, String password){
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

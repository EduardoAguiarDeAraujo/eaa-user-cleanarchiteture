package br.eng.eaa.domain.entity;

import br.eng.eaa.domain.valueobject.Password;

import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private Password password;

    public User (String name, String password){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty or null");
        }
        this.id = UUID.randomUUID();
        this.name = name;
        this.password = new Password(password);
    }

    public User(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

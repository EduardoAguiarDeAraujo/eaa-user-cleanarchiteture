package br.eng.eaa.domain.entity;

import br.eng.eaa.domain.valueobject.Password;

import java.util.Objects;
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

    public Password getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

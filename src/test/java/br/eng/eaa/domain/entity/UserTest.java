package br.eng.eaa.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    @DisplayName("Deve retornar um usuário válido")
    public void createUserValido() {

        User user = new User("Eduardo", "MInhaSenhaForte1#");

        assert user != null;
        assert user.getName().equals("Eduardo");

        System.out.println("ID: " + user.getId() + " - " + user.getName());
    }
    @Test
    @DisplayName("Deve retornar um erro ao criar usuário com nome nulo")
    public void createUserInvalido() {
        String nameInvalid = null;
        assertThrows(IllegalArgumentException.class, () -> new User(nameInvalid, "MInhaSenhaForte1"));
    }
    @Test
    @DisplayName("Deve retornar um erro ao criar usuário com nome vazio")
    public void createUserWithNameVazio() {
        String nameInvalid = "";
        assertThrows(IllegalArgumentException.class, () -> new User(nameInvalid, "MInhaSenhaForte1"));
    }
    @Test
    @DisplayName("Deve retornar um erro ao criar usuário com nome nulo")
    public void createUserWithNameNulo() {
        String nameInvalid = null;
        assertThrows(IllegalArgumentException.class, () -> new User(nameInvalid, "MInhaSenhaForte1"));
    }

}
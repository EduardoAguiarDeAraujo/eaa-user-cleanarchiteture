package br.eng.eaa.application.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserResponseTest {

    @Test
    @DisplayName("Deve criar um usuário com ID e nome válidos")
    void createUserResponseValido() {
        UserResponse userResponse = new UserResponse(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"), "Katia");
        assertNotNull(userResponse);
        assertEquals(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"), userResponse.getId());
        assertEquals("Katia", userResponse.getName());
        System.out.printf("ID: %s - %s%n", userResponse.getId(), userResponse.getName());
    }
    @Test
    @DisplayName("Deve lançar uma exceção ao criar um usuário com ID nulo")
    void setId() {
        UUID invalidId = null;
        assertThrows(IllegalArgumentException.class, () -> new UserResponse(invalidId, "Katia"),
                "Deveria lançar IllegalArgumentException para ID nulo");
        System.out.println("Exceção lançada corretamente para ID nulo.");
    }
    @Test
    @DisplayName("Deve lançar uma exceção ao criar um usuário com nome nulo")
    void deveLancarExceptionQuandoCriarUmUsuarioComNomeNuloe() {
        String invalidName = null;
        assertThrows(IllegalArgumentException.class, () -> new UserResponse(UUID.randomUUID(), invalidName));
        System.out.println("Exceção lançada corretamente para nome nulo.");
    }
    @Test
    @DisplayName("Deve lançar uma exceção ao criar um usuário com nome vazio")
    void setName() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new UserResponse(UUID.randomUUID(), invalidName),
                "Deveria lançar IllegalArgumentException para nome vazio");
        System.out.println("Exceção lançada corretamente para nome vazio.");
    }
    @Test
    @DisplayName("Deve criar um usuário com ID e nome válidos")
    void createUserResponseComIdENomeValidos() {
        UserResponse userResponse = new UserResponse(UUID.randomUUID(), "João");
        assertNotNull(userResponse);
        assertNotNull(userResponse.getId());
        assertEquals("João", userResponse.getName());
        System.out.printf("ID: %s - %s%n", userResponse.getId(), userResponse.getName());
    }
    @Test
    @DisplayName("Deve setar um usuário com ID e nome válidos")
    void setUserResponseComIdENomeValidos() {
        UserResponse userResponse = new UserResponse(UUID.randomUUID(), "Maria");
        UUID newId = UUID.randomUUID();
        String newName = "Ana";
        userResponse.setId(newId);
        userResponse.setName(newName);
        assertEquals(newId, userResponse.getId());
        assertEquals(newName, userResponse.getName());
        System.out.printf("ID atualizado: %s - Nome atualizado: %s%n", userResponse.getId(), userResponse.getName());
    }
}
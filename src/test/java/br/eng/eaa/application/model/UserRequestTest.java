package br.eng.eaa.application.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRequestTest {


    @Test
    @DisplayName("Deve criar um usuário com nome e senha válidos")
    void getId() {
        UserRequest userRequest = new UserRequest("Alice", "StrongPassword123#");
        assertNotNull(userRequest);
        assertEquals("Alice", userRequest.getName(), "O nome do usuário deve ser 'Alice'");
        assertEquals("StrongPassword123#", userRequest.getPassword(), "A senha do usuário deve ser 'StrongPassword123#'");

        System.out.println("Usuário criado com sucesso: " + userRequest.getName());
    }

    @Test
    @DisplayName("Deve lançar uma exceção ao criar um usuário com nome nulo")
    void getName() {
        String invalidName = null;
        assertThrows(IllegalArgumentException.class, () -> new UserRequest(invalidName, "StrongPassword123#"),"Deveria lançar IllegalArgumentException para nome nulo");

        System.out.println("Exceção lançada corretamente para nome nulo.");
    }

    @Test
    @DisplayName("Deve lançar uma exceção ao criar um usuário com senha nula")
    void getPassword() {
        String invalidPassword = null;
        assertThrows(IllegalArgumentException.class, () -> new UserRequest("Alice", invalidPassword),
                "Deveria lançar IllegalArgumentException para senha nula");

        System.out.println("Exceção lançada corretamente para senha nula.");
    }
}
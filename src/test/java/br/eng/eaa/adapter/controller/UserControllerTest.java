package br.eng.eaa.adapter.controller;

import br.eng.eaa.adapter.gateway.IUserGatewayStub;
import br.eng.eaa.application.model.UserRequest;
import br.eng.eaa.application.model.UserResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserControllerTest {

    private UserController userController;

    @BeforeEach
    void setUp() {
        IUserGatewayStub gateway = new IUserGatewayStub();
        userController = new UserController(gateway);
    }

    @AfterEach
    void tearDown() {
        userController = null;
    }

    @Test
    @DisplayName("Deve salvar um usuário")
    void save(){
        UserRequest userRequest = new UserRequest("Eduardo","MinhaSenhaForte#10");
        UserResponse userResponse = userController.save(userRequest);
        assertNotNull(userResponse);
        assertEquals("Eduardo", userResponse.getName());
        System.out.printf("ID: %s - %s ", userResponse.getId(), userResponse.getName());
    }

    @Test
    @DisplayName("Deve atualizar um usuário")
    void update(){
        UserRequest userRequest = new UserRequest(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"), "Katia");
        UserResponse userResponse = userController.update(userRequest);
        assertNotNull(userResponse);
        assertEquals(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"), userResponse.getId());
        assertNotNull(userResponse.getName());
        assertEquals("Katia", userResponse.getName());
        System.out.printf("ID: %s - %s ", userResponse.getId(), userResponse.getName());
    }

    @Test
    @DisplayName("Deve encontrar um usuário pelo id.")
    void findById(){
        UserResponse userResponse = userController.findById(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"));
        assertNotNull(userResponse);
        assertEquals("Katia", userResponse.getName());
        System.out.printf("ID: %s - %s ", userResponse.getId(), userResponse.getName());
    }

    @Test
    @DisplayName("Deve excluir um usuário pelo id.")
    void delete(){
        Boolean isDeleted = userController.delete(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"));
        assertNotNull(isDeleted);
        assertEquals(true, isDeleted);
        System.out.printf("Usuário excluído: %s", isDeleted);
    }

    @Test
    @DisplayName("Deve listar todos os usuários.")
    void findAll() {
        var users = userController.findAll();
        assertNotNull(users);
        assertEquals(3, users.size());
        users.forEach(user -> System.out.printf("ID: %s - %s%n", user.getId(), user.getName()));
    }
}

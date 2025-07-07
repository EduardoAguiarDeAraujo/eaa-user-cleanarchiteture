package br.eng.eaa.application.usecase;

import br.eng.eaa.adapter.gateway.IUserGateway;
import br.eng.eaa.adapter.gateway.IUserGatewayStub;
import br.eng.eaa.adapter.presenter.UserPresenter;
import br.eng.eaa.application.boundary.output.UserOutput;
import br.eng.eaa.application.model.UserRequest;
import br.eng.eaa.application.model.UserResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserInteractorTest {

    private UserOutput userOutput;
    private IUserGateway userGateway;

    @BeforeEach
    void setUp() {
        this.userOutput = new  UserPresenter();
        this.userGateway = new IUserGatewayStub();
    }

    @AfterEach
    void tearDown() {
        userOutput = null;
        userGateway = null;
        System.out.println("Limpeza após os testes concluída.");
    }

    @Test
    @DisplayName("Deve construir o UserInteractor corretamente")
    void builder() {
        UserInteractor userInteractor = UserInteractor.builder(userOutput, userGateway);

        assertNotNull(userInteractor);
        System.out.println("UserInteractor construído com sucesso.");
    }

    @Test
    @DisplayName("Deve salvar um usuário")
    void save() {
        UserInteractor userInteractor = UserInteractor.builder(userOutput, userGateway);
        UserRequest userRequest = new UserRequest("Eduardo", "MinhaSenhaForte#10");
        UserResponse userResponse = userInteractor.save(userRequest);

        assertNotNull(userResponse);
        assertEquals("Eduardo", userResponse.getName());
        System.out.printf("ID: " + userResponse.getId() + " - " + userResponse.getName());
    }

    @Test
    @DisplayName("Deve atualizar um usuário")
    void update() {
        UserInteractor userInteractor = UserInteractor.builder(userOutput, userGateway);
        UserRequest userRequest = new UserRequest(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"), "Katia");

        UserResponse userResponse = userInteractor.update(userRequest);

        assertNotNull(userResponse);
        assertEquals(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"), userResponse.getId());
        assertEquals("Katia", userResponse.getName());
        System.out.printf("ID: %s - %s", userResponse.getId(), userResponse.getName());
    }

    @Test
    @DisplayName("Deve encontrar um usuário pelo id")
    void findById() {
        UserInteractor userInteractor = UserInteractor.builder(userOutput, userGateway);
        UserResponse userResponse = userInteractor.findById(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"));

        assertNotNull(userResponse);
        assertEquals("Katia", userResponse.getName());
        System.out.printf("ID: %s - %s", userResponse.getId(), userResponse.getName());
    }

    @Test
    void findAll() {
        UserInteractor userInteractor = UserInteractor.builder(userOutput, userGateway);
        var users = userInteractor.findAll();

        assertNotNull(users);
        assertFalse(users.isEmpty(), "A lista de usuários não deve estar vazia.");
        System.out.println("Lista de usuários encontrada com sucesso.");
        users.forEach(user -> System.out.printf("ID: " + user.getId() + " - " + user.getName()));
    }

    @Test
    void delete() {
        UserInteractor userInteractor = UserInteractor.builder(userOutput, userGateway);
        Boolean isDeleted = userInteractor.delete(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"));

        assertTrue(isDeleted);
        System.out.println("Usuário excluído com sucesso.");
    }
}
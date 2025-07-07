package br.eng.eaa.adapter.presenter;

import br.eng.eaa.application.model.UserResponse;
import br.eng.eaa.domain.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserPresenterTest {

    private UserPresenter userPresenter;

    @BeforeEach
    void setUp() {
        userPresenter = new UserPresenter();
        System.out.println("Configurando UserPresenter para o teste.");
    }

    @AfterEach
    void tearDown() {
        userPresenter = null; // Opcional: Para liberar a referência
        System.out.println("Desmontagem do teste concluída.");
    }

    @Test
    @DisplayName("Deve converter um único objeto User para UserResponse corretamente")
    void shouldConvertSingleUserToUserResponse() {
        // Given
        UUID userId = UUID.randomUUID();
        String userName = "Alice";
        User user = new User(userId, userName);

        // When
        UserResponse userResponse = userPresenter.execute(user);

        // Then
        assertNotNull(userResponse, "UserResponse não deve ser nulo");
        assertEquals(userId, userResponse.getId(), "O ID do UserResponse deve corresponder ao ID do User");
        assertEquals(userName, userResponse.getName(), "O nome do UserResponse deve corresponder ao nome do User");
        System.out.println("Teste 'shouldConvertSingleUserToUserResponse' concluído.");
    }

    @Test
    @DisplayName("Deve converter uma lista de objetos User para uma lista de UserResponse corretamente")
    void shouldConvertListOfUsersToListOfUserResponses() {
        // Given
        User user1 = new User(UUID.randomUUID(), "Bob");
        User user2 = new User(UUID.randomUUID(), "Charlie");
        List<User> users = Arrays.asList(user1, user2);

        // When
        List<UserResponse> userResponses = userPresenter.execute(users);

        // Then
        assertNotNull(userResponses, "A lista de UserResponse não deve ser nula");
        assertEquals(2, userResponses.size(), "A lista de UserResponse deve conter 2 elementos");

        UserResponse response1 = userResponses.get(0);
        assertEquals(user1.getId(), response1.getId(), "O ID do primeiro UserResponse deve corresponder");
        assertEquals(user1.getName(), response1.getName(), "O nome do primeiro UserResponse deve corresponder");

        UserResponse response2 = userResponses.get(1);
        assertEquals(user2.getId(), response2.getId(), "O ID do segundo UserResponse deve corresponder");
        assertEquals(user2.getName(), response2.getName(), "O nome do segundo UserResponse deve corresponder");
        System.out.println("Teste 'shouldConvertListOfUsersToListOfUserResponses' concluído.");
    }

    @Test
    @DisplayName("Deve retornar uma lista vazia quando uma lista de User vazia é fornecida")
    void shouldReturnEmptyListWhenEmptyListOfUsersIsProvided() {
        // Given
        List<User> users = List.of(); // Lista vazia

        // When
        List<UserResponse> userResponses = userPresenter.execute(users);

        // Then
        assertNotNull(userResponses, "A lista de UserResponse não deve ser nula");
        assertEquals(0, userResponses.size(), "A lista de UserResponse deve estar vazia");
        System.out.println("Teste 'shouldReturnEmptyListWhenEmptyListOfUsersIsProvided' concluído.");
    }
}
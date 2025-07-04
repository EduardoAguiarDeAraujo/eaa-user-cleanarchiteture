package br.eng.eaa.adapter.controller;

import br.eng.eaa.adapter.gateway.IUserGatewayStub;
import br.eng.eaa.application.model.UserRequest;
import br.eng.eaa.application.model.UserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UserControllerTest {

    IUserGatewayStub gateway = new IUserGatewayStub();
    UserController userController = new UserController(gateway);

    @Test
    @DisplayName("Deve salvar um usuário")
    public void save(){
        UserRequest userRequest = new UserRequest("Eduardo","MinhaSenhaForte#10");
        UserResponse userResponse = userController.save(userRequest);
        assert userResponse != null;
        assert userResponse.getName().equals("Eduardo");
        System.out.printf("ID: " + userResponse.getId() + " - " + userResponse.getName());
    }

    @Test
    @DisplayName("Deve atualizar um usuário")
    public void update(){
        UserRequest userRequest = new UserRequest(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"), "Katia");
        UserResponse userResponse = userController.update(userRequest);
        assert userResponse != null;
        assert userResponse.getName().equals("Katia");
        System.out.printf("ID: " + userResponse.getId() + " - " + userResponse.getName());
    }

    @Test
    @DisplayName("Deve encontrar um usuário pelo id.")
    public void findById(){
        UserResponse userResponse = userController.findById(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"));
        assert userResponse != null;
        assert userResponse.getName().equals("Katia");
        System.out.printf("ID: " + userResponse.getId() + " - " + userResponse.getName());
    }

    @Test
    @DisplayName("Deve excluir um usuário pelo id.")
    public void delete(){
        Boolean isDeleted = userController.delete(UUID.fromString("e7007913-6fef-4d5d-9b29-ed68af616ffa"));
        assert isDeleted.equals(true);
    }
}

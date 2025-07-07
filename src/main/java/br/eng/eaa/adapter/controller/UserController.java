package br.eng.eaa.adapter.controller;

import br.eng.eaa.adapter.gateway.IUserGateway;
import br.eng.eaa.adapter.presenter.UserPresenter;
import br.eng.eaa.application.boundary.input.UserInput;
import br.eng.eaa.application.boundary.output.UserOutput;
import br.eng.eaa.application.model.UserRequest;
import br.eng.eaa.application.model.UserResponse;
import br.eng.eaa.application.usecase.UserInteractor;

import java.util.List;
import java.util.UUID;

public class UserController {

    private UserInput userInput;

    public UserController(IUserGateway userGateway) {
        UserOutput userOutput = new UserPresenter();
        this.userInput = UserInteractor.builder(userOutput, userGateway);
    }

    public UserResponse save(UserRequest userRequest){
        return userInput.save(userRequest);
    }

    public UserResponse update(UserRequest userRequest) {
        return userInput.update(userRequest);
    }

    public UserResponse findById(UUID id){
        return userInput.findById(id);
    }

    public List<UserResponse> findAll(){
        return userInput.findAll();
    }

    public Boolean delete(UUID id){
        return userInput.delete(id);
    }

}

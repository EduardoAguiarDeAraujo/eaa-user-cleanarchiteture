package br.eng.eaa.application.usecase;

import br.eng.eaa.adapter.gateway.IUserGateway;
import br.eng.eaa.application.boundary.input.UserInput;
import br.eng.eaa.application.boundary.output.UserOutput;
import br.eng.eaa.application.model.UserRequest;
import br.eng.eaa.application.model.UserResponse;
import br.eng.eaa.domain.entity.User;

import java.util.List;
import java.util.UUID;

public class UserInteractor implements UserInput {

    private IUserGateway userGateway;
    private UserOutput userOutput;

    private UserInteractor(UserOutput userOutput, IUserGateway userGateway) {
        this.userGateway = userGateway;
        this.userOutput = userOutput;
    }

    public static UserInteractor builder(UserOutput userOutput, IUserGateway userGateway){
        return new UserInteractor(userOutput, userGateway);
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        User user = new User(userRequest.getName(), userRequest.getPassword());
        User userSaved = userGateway.save(user);
        return userOutput.execute(userSaved);
    }

    @Override
    public UserResponse update(UserRequest userRequest) {
        User user = new User(userRequest.getId(), userRequest.getName());
        User userSaved = userGateway.update(user);
        return userOutput.execute(userSaved);
    }

    @Override
    public UserResponse findById(UUID id) {
        User user = userGateway.findById(id);
        return userOutput.execute(user);
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userGateway.findAll();
        return userOutput.execute(users);
    }

    @Override
    public Boolean delete(UUID id) {
        return userGateway.delete(id);
    }
}

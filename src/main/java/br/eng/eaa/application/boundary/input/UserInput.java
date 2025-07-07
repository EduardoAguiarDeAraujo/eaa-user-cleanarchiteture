package br.eng.eaa.application.boundary.input;

import br.eng.eaa.application.model.UserRequest;
import br.eng.eaa.application.model.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserInput {
    UserResponse save(UserRequest userRequest);
    UserResponse update(UserRequest userRequest);
    UserResponse findById(UUID id);
    List<UserResponse> findAll();
    Boolean delete(UUID id);
}

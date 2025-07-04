package br.eng.eaa.application.boundary.output;

import br.eng.eaa.application.model.UserResponse;
import br.eng.eaa.domain.entity.User;

import java.util.List;

public interface UserOutput {
    UserResponse execute(User user);
    List<UserResponse> execute(List<User> users);
}

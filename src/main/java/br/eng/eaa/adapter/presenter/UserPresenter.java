package br.eng.eaa.adapter.presenter;

import br.eng.eaa.application.boundary.output.UserOutput;
import br.eng.eaa.application.model.UserResponse;
import br.eng.eaa.domain.entity.User;

import java.util.List;

public class UserPresenter implements UserOutput {

    @Override
    public UserResponse execute(User user) {
        return new UserResponse(user.getId(), user.getName());
    }

    @Override
    public List<UserResponse> execute(List<User> users) {
        return users.stream().map(u -> new UserResponse(u.getId(),u.getName())).toList();
    }
}

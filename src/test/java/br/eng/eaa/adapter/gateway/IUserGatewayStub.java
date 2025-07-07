package br.eng.eaa.adapter.gateway;

import br.eng.eaa.domain.entity.User;

import java.util.List;
import java.util.UUID;

public class IUserGatewayStub implements IUserGateway{


    @Override
    public User save(User user) {
        return user;
    }

    @Override
    public User update(User user) {
        User userUpdated = new User(user.getId(), user.getName());
        return userUpdated;
    }

    @Override
    public User fingById(UUID id) {
        return new User(id, "Katia");
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Boolean delete(UUID id) {
        return true;
    }
}

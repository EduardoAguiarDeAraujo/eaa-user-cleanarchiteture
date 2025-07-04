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
        return user;
    }

    @Override
    public User fingById(UUID id) {
        User user = new User(id, "Katia");
        return user;
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

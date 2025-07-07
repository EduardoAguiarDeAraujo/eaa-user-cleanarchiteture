package br.eng.eaa.adapter.gateway;

import br.eng.eaa.domain.entity.User;

import java.util.ArrayList;
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
    public User findById(UUID id) {
        return new User(id, "Katia");
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID(), "Katia"));
        users.add(new User(UUID.randomUUID(), "Eduardo"));
        users.add(new User(UUID.randomUUID(), "Rebeca"));

        return users;
    }

    @Override
    public Boolean delete(UUID id) {
        return true;
    }
}

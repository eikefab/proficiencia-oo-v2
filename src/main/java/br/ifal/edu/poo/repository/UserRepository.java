package br.ifal.edu.poo.repository;

import br.ifal.edu.poo.entities.User;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface UserRepository {

    User create(User user);
    void delete(User user);

    Set<User> fetchUsers();
    Optional<User> fetchUserById(UUID id);
    Optional<User> fetchUserByEmail(String email);

}

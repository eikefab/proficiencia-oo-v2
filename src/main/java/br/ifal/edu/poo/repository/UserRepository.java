package br.ifal.edu.poo.repository;

import br.ifal.edu.poo.entities.Group;
import br.ifal.edu.poo.entities.User;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface UserRepository {

    User create(User user);
    void delete(User user);

    User login(String email, String password);

    Set<User> fetchUsers();
    Optional<User> fetchUserById(UUID id);
    Optional<User> fetchUserByEmail(String email);

    Set<Group> fetchGroups();
    Set<Group> fetchUserGroups(User user);

    Group fetchGroupById(UUID id);
    Group fetchGroupByName(String name);

    void createGroup(User owner, Group group);
    void joinGroup(User user, Group group);
    void leaveGroup(User user, Group group);

}

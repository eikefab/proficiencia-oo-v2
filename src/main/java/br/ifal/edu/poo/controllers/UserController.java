package br.ifal.edu.poo.controllers;

import br.ifal.edu.poo.entities.*;
import br.ifal.edu.poo.exceptions.group.GroupFullException;
import br.ifal.edu.poo.exceptions.group.GroupNameAlreadyInUseException;
import br.ifal.edu.poo.exceptions.group.GroupNotFoundException;
import br.ifal.edu.poo.exceptions.user.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserController {

    User register(String email, String password) throws UserEmailAlreadyExistsException, UserPasswordInvalidException;
    User login(String email, String password) throws UserNotFoundException, UserPasswordMismatchException;

    boolean exists(String email);
    boolean exists(UUID id);

    Set<User> fetchUsers();
    User fetchUserByEmail(String email) throws UserNotFoundException;
    User fetchUserById(UUID id) throws UserNotFoundException;

    void joinGroup(User user, Group group) throws GroupNotFoundException, GroupFullException;
    void leaveGroup(User user, Group group) throws GroupNotFoundException;
    void createGroup(String name, List<User> participants) throws GroupNameAlreadyInUseException;
}

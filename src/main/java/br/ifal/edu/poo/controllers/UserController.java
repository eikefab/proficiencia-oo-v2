package br.ifal.edu.poo.controllers;

import br.ifal.edu.poo.entities.*;
import br.ifal.edu.poo.exceptions.user.*;

import java.util.Set;
import java.util.UUID;

public interface UserController {

    User register(String email, String password) throws UserEmailAlreadyExistsException, UserPasswordInvalidException;
    User login(String email, String password) throws UserNotFoundException, UserPasswordMismatchException;

    Set<User> fetchUsers();
    User fetchUserByEmail(String email) throws UserNotFoundException;
    User fetchUserById(UUID id) throws UserNotFoundException;
}

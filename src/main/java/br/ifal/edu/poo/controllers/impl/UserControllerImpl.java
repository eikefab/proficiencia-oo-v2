package br.ifal.edu.poo.controllers.impl;

import br.ifal.edu.poo.controllers.UserController;
import br.ifal.edu.poo.entities.User;
import br.ifal.edu.poo.entities.UserBuilder;
import br.ifal.edu.poo.exceptions.user.UserEmailAlreadyExistsException;
import br.ifal.edu.poo.exceptions.user.UserNotFoundException;
import br.ifal.edu.poo.exceptions.user.UserPasswordInvalidException;
import br.ifal.edu.poo.exceptions.user.UserPasswordMismatchException;
import br.ifal.edu.poo.repository.UserRepository;
import br.ifal.edu.poo.repository.impl.UserRepositoryImpl;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class UserControllerImpl implements UserController {

    private static final UserControllerImpl INSTANCE = new UserControllerImpl();

    private final UserRepository repository;

    private UserControllerImpl() {
        this.repository = UserRepositoryImpl.getInstance();
    }

    @Override
    public User register(String email, String password) throws UserEmailAlreadyExistsException, UserPasswordInvalidException {
        final Optional<User> record = repository.fetchUserByEmail(email);

        if (record.isPresent()) {
            throw new UserEmailAlreadyExistsException(email);
        }

        if (password.trim().isEmpty()) {
            throw new UserPasswordInvalidException();
        }

        final User user = new User(UserBuilder.newInstance()
                .email(email)
                .password(password));

        repository.create(user);

        return user;
    }

    @Override
    public User login(String email, String password) throws UserNotFoundException, UserPasswordMismatchException {
        final User user = fetchUserByEmail(email);

        if (!user.getPassword().equalsIgnoreCase(password)) {
            throw new UserPasswordMismatchException();
        }

        return user;
    }

    @Override
    public Set<User> fetchUsers() {
        return repository.fetchUsers();
    }

    @Override
    public User fetchUserByEmail(String email) throws UserNotFoundException {
        final Optional<User> record = repository.fetchUserByEmail(email);

        if (record.isEmpty()) {
            throw new UserNotFoundException();
        }

        return record.get();
    }

    @Override
    public User fetchUserById(UUID id) throws UserNotFoundException {
        final Optional<User> record = repository.fetchUserById(id);

        if (record.isEmpty()) {
            throw new UserNotFoundException();
        }

        return record.get();
    }

    public static UserControllerImpl getInstance() {
        return INSTANCE;
    }

}

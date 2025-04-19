package br.ifal.edu.poo.repository.impl;

import br.ifal.edu.poo.entities.User;
import br.ifal.edu.poo.entities.UserBuilder;
import br.ifal.edu.poo.repository.Repository;
import br.ifal.edu.poo.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public final class UserRepositoryImpl implements UserRepository {

    private static final UserRepositoryImpl INSTANCE = new UserRepositoryImpl();

    public static UserRepositoryImpl getInstance() {
        return INSTANCE;
    }

    private final Connection connection;

    private UserRepositoryImpl() {
        this.connection = Repository.getSqlConnection();
    }

    @Override
    public User create(User user) {
        final String query = "insert into `tb_users` (`user_id`, `email`, `password`) values (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUniqueId().toString());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();
        } catch (SQLException exception) {
            return null;
        }

        return user;
    }

    @Override
    public void delete(User user) {
        final String query = "delete from `tb_users` where `user_id` = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUniqueId().toString());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Set<User> fetchUsers() {
        final Set<User> users = new HashSet<>();
        final String query = "select `user_id`, `email` from `tb_users`;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    final UUID userId = UUID.fromString(resultSet.getString("id"));
                    final String email = resultSet.getString("email");

                    final User user = new User(UserBuilder.newInstance().uniqueId(userId).email(email));

                    users.add(user);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return users;
    }

    @Override
    public Optional<User> fetchUserById(UUID id) {
        final String query = "select `user_id`, `email` from `tb_users` where `user_id` = ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id.toString());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    final UUID userId = UUID.fromString(resultSet.getString("id"));
                    final String email = resultSet.getString("email");

                    final User user = new User(UserBuilder.newInstance().uniqueId(userId).email(email));

                    return Optional.of(user);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> fetchUserByEmail(String email) {
        final String query = "select `user_id`, `email` from `tb_users` where `email` = ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    final UUID id = UUID.fromString(resultSet.getString("id"));

                    final User user = new User(UserBuilder.newInstance().uniqueId(id).email(email));

                    return Optional.of(user);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return Optional.empty();
    }
}

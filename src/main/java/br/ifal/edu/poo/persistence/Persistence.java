package br.ifal.edu.poo.persistence;

import java.sql.Connection;

public final class Persistence {

    private static final Persistence INSTANCE = new Persistence();

    public static Persistence getInstance() {
        return INSTANCE;
    }

    private final Connection connection;

    private Persistence() {
        this.connection = connect();
    }

    public Connection connect() {
        try (Connection connection = PersistenceFactory.createConnection()) {
            PersistenceFactory.runDDLs(connection);

            return connection;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public Connection getConnection() {
        return connection;
    }
}

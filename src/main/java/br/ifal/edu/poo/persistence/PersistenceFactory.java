package br.ifal.edu.poo.persistence;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.stream.Collectors;

public final class PersistenceFactory {

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        return DriverManager.getConnection("jdbc:h2:mem:");
    }

    public static void runDDLs(Connection connection) {
        final InputStream stream = ClassLoader.getSystemResourceAsStream("ddls.sql");

        if (stream == null) {
            throw new IllegalArgumentException();
        }

        final BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        final String data = reader.lines().collect(Collectors.joining("\n"));
        final String[] lines = data.split("\n");

        System.out.println("[SQL] Iniciando execução de DDLs...");

        try (Statement statement = connection.createStatement()) {
            for (String line : lines) {
                final String ddl = line.trim();

                if (ddl.isEmpty()) {
                    continue;
                }

                System.out.format("[SQL] Script: '%s'", ddl).println();

                statement.executeUpdate(ddl);
            }

            System.out.println("[SQL] Sucesso.");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("[SQL] Execução de DDLs finalizada.");
    }

}

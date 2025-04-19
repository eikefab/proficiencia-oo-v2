package br.ifal.edu.poo.repository;

import br.ifal.edu.poo.persistence.Persistence;

import java.sql.Connection;

public final class Repository {

    private static final Connection SQL_CONNECTION = Persistence.getInstance().connect();

    public static Connection getSqlConnection() {
        return SQL_CONNECTION;
    }
}

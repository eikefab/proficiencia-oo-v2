package br.ifal.edu.poo.entities;

import java.util.UUID;

public class User {

    private final UUID uniqueId;
    private final String email;
    private final String password;

    public User(UserBuilder builder) {
        this.uniqueId = builder.getUniqueId();
        this.email = builder.getEmail();
        this.password = builder.getPassword();
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

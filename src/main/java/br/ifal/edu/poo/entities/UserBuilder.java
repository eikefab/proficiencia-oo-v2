package br.ifal.edu.poo.entities;

import java.util.UUID;

public class UserBuilder {

    public static UserBuilder newInstance() {
        return new UserBuilder();
    }

    private UUID uniqueId;
    private String email;
    private String password;

    public UserBuilder() {
        this.uniqueId = UUID.randomUUID();
    }

    public UserBuilder uniqueId(UUID id) {
        this.uniqueId = id;

        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;

        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;

        return this;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}

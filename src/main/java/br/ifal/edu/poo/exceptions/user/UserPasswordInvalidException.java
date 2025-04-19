package br.ifal.edu.poo.exceptions.user;

public class UserPasswordInvalidException extends RuntimeException {

    public UserPasswordInvalidException() {
        super("A senha utilizada é inválida!");
    }

}

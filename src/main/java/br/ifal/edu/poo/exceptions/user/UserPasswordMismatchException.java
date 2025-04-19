package br.ifal.edu.poo.exceptions.user;

public class UserPasswordMismatchException extends RuntimeException {

    public UserPasswordMismatchException() {
        super("As senhas não coincidem.");
    }

}

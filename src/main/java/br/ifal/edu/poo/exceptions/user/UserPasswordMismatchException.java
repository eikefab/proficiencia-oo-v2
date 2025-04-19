package br.ifal.edu.poo.exceptions.user;

public class UserPasswordMismatchException extends Exception {

    public UserPasswordMismatchException() {
        super("As senhas não coincidem.");
    }

}

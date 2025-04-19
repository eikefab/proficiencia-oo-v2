package br.ifal.edu.poo.exceptions.user;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("Usuário não encontrado no sistema.");
    }

}

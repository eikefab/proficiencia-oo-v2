package br.ifal.edu.poo.exceptions.user;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Usuário não encontrado no sistema.");
    }

}

package br.ifal.edu.poo.exceptions.user;

public class UserEmailAlreadyExistsException extends Exception {

    public UserEmailAlreadyExistsException(String email) {
        super("O e-mail " + email + " já está cadastrado no sistema.");
    }

}

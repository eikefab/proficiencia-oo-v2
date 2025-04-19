package br.ifal.edu.poo.exceptions.group;

public class GroupNameAlreadyInUseException extends Exception {

    public GroupNameAlreadyInUseException() {
        super("O nome do grupo já está sendo utilizado.");
    }

}

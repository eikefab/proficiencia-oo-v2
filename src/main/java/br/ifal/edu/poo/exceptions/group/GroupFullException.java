package br.ifal.edu.poo.exceptions.group;

public class GroupFullException extends Exception {

    public GroupFullException() {
        super("Grupo já está cheio!");
    }

}

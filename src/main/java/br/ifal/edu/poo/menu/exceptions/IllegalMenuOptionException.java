package br.ifal.edu.poo.menu.exceptions;

public class IllegalMenuOptionException extends IllegalArgumentException {

    public IllegalMenuOptionException() {
        super("Isso é um erro! Opção não deveria ter sido liberada.");
    }

}

package br.ifal.edu.poo.menu.exceptions;

public class MenuIllegalOptionException extends IllegalArgumentException {

    public MenuIllegalOptionException() {
        super("Isso é um erro! Opção não deveria ter sido liberada.");
    }

}

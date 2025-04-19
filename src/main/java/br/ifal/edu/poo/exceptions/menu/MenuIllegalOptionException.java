package br.ifal.edu.poo.exceptions.menu;

public class MenuIllegalOptionException extends IllegalArgumentException {

    public MenuIllegalOptionException() {
        super("Isso é um erro! Opção não deveria ter sido liberada.");
    }

}

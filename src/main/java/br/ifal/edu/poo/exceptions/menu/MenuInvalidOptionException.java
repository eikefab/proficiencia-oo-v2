package br.ifal.edu.poo.exceptions.menu;

public class MenuInvalidOptionException extends RuntimeException {

    public MenuInvalidOptionException() {
        super("(Opção inválida)\n> ");
    }

}

package br.ifal.edu.poo.menu.exceptions;

public class MenuInvalidOptionException extends RuntimeException {

    public MenuInvalidOptionException() {
        super("(Opção inválida)\n> ");
    }

}

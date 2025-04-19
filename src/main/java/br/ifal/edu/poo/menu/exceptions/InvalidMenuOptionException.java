package br.ifal.edu.poo.menu.exceptions;

public class InvalidMenuOptionException extends RuntimeException {

    public InvalidMenuOptionException() {
        super("(Opção inválida)\n> ");
    }

}

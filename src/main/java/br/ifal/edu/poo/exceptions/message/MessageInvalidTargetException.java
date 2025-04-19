package br.ifal.edu.poo.exceptions.message;

public class MessageInvalidTargetException extends RuntimeException {

    public MessageInvalidTargetException() {
        super("Destinatário inválido.");
    }

}

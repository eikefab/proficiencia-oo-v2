package br.ifal.edu.poo.exceptions.message;

public class MessageInvalidTargetException extends Exception {

    public MessageInvalidTargetException() {
        super("Destinatário inválido.");
    }

}

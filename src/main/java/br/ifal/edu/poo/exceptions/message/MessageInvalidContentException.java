package br.ifal.edu.poo.exceptions.message;

public class MessageInvalidContentException extends Exception {

    public MessageInvalidContentException() {
        super("O conteúdo da mensagem é inválido.");
    }

}

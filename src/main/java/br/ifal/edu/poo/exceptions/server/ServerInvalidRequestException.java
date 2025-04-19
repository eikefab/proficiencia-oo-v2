package br.ifal.edu.poo.exceptions.server;

public class ServerInvalidRequestException extends ServerException {

    public ServerInvalidRequestException() {
        super("invalid_request", "Requisição com formato inválido.");
    }

}

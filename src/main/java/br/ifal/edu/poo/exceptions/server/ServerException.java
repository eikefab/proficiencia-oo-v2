package br.ifal.edu.poo.exceptions.server;

public class ServerException extends RuntimeException {

    private final String exceptionId;

    public ServerException(String exceptionId, String message) {
        super(message);

        this.exceptionId = "error::" + exceptionId;
    }

    public String getExceptionId() {
        return exceptionId;
    }

}

package br.ifal.edu.poo;

import br.ifal.edu.poo.socket.ChatClient;

import java.net.ServerSocket;
import java.net.Socket;

public final class Server {

    private static final int DEFAULT_SERVER_PORT = 3000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(DEFAULT_SERVER_PORT)) {
            System.out.println("[INFO] Servidor rodando na porta " + DEFAULT_SERVER_PORT);

            while (true) {
                final Socket socket = serverSocket.accept();

                new Thread(() -> {
                    try {
                        final ChatClient client = new ChatClient(socket);

                        System.out.println("[INFO] Conectado: " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());

                        client.run();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}

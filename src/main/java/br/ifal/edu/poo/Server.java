package br.ifal.edu.poo;

import br.ifal.edu.poo.socket.ChatClient;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Server {

    private static final int DEFAULT_SERVER_PORT = 3000;
    public static final List<ChatClient> CONNECTED_CLIENTS = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(DEFAULT_SERVER_PORT)) {
            System.out.println("[INFO] Servidor rodando na porta " + DEFAULT_SERVER_PORT);

            while (true) {
                final Socket socket = serverSocket.accept();
                System.out.println("[INFO] Conectado: " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());

                new Thread(() -> {
                    try {
                        final ChatClient client = new ChatClient(socket);
                        CONNECTED_CLIENTS.add(client);

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

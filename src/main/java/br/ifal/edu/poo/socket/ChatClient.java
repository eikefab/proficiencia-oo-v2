package br.ifal.edu.poo.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient implements Runnable {

    private final Socket socket;

    public ChatClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String input;

        try (
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            while ((input = reader.readLine()) != null) {
                if (input.equalsIgnoreCase("disconnect")) {
                    socket.close();

                    break;
                }

                writer.println("hi there");
                writer.flush();
            }

            System.out.println("[INFO] Desconectado: " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

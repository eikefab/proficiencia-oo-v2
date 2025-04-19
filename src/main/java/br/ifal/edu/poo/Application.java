package br.ifal.edu.poo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public final class Application {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        PrintWriter writer = new PrintWriter(socket.getOutputStream());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                    System.out.println("Cliente: " + socket);

                    writer.println("hi there");
                    writer.flush();

                    String input;

                    while ((input = reader.readLine()) != null) {
                        System.out.println(input);
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}

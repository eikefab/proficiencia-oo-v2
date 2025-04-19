package br.ifal.edu.poo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;

public class ClientApplication {

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("127.0.0.1", 3000);
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.println("> ");
                    String a = scanner.nextLine();

                    writer.println(Base64.getEncoder().encodeToString(a.getBytes()));
                    writer.flush();

                    String output = reader.readLine();

                    if (output == null) {
                        break;
                    }

                    System.out.println(output);

                    if (output.equalsIgnoreCase("disconnect")) {
                        break;
                    }
                }
            }
        } catch (ConnectException exception) {
            System.out.println("Não foi possível localizar o servidor.");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}

package br.ifal.edu.poo.menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
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

                    writer.println(a);
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

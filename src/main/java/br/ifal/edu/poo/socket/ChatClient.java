package br.ifal.edu.poo.socket;

import br.ifal.edu.poo.Server;
import br.ifal.edu.poo.socket.event.ChatEvent;
import br.ifal.edu.poo.socket.event.ChatEventHandler;
import br.ifal.edu.poo.socket.event.ChatEventListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Base64;

public class ChatClient implements Runnable {

    private final Socket socket;
    private final ChatEventHandler handler;

    public ChatClient(Socket socket) {
        this.socket = socket;
        this.handler = new ChatEventHandler(this);
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        String input;

        try (
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            while ((input = reader.readLine()) != null) {
                final byte[] bytes = Base64.getDecoder().decode(input);
                final String data = new String(bytes);

                if (data.equalsIgnoreCase("disconnect")) {
                    socket.close();

                    break;
                }

                final ChatEvent event = ChatEvent.stripEvent(data);

                if (event == null) {
                    writer.println("Ação desconhecida.");
                    writer.flush();

                    continue;
                }

                final ChatEventListener listener = handler.getListener(event);

                if (listener == null) {
                    writer.println("Ação não implementada.");
                    writer.flush();

                    continue;
                }

                listener.listen(data.split(ChatEventHandler.EVENT_DATA_SEPARATOR)[1], writer);
                writer.flush();
            }

            System.out.println("[INFO] Desconectado: " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());

            Server.CONNECTED_CLIENTS.remove(this);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

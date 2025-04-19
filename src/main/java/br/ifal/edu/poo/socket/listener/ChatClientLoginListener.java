package br.ifal.edu.poo.socket.listener;

import br.ifal.edu.poo.socket.event.ChatEventListener;

import java.io.PrintWriter;

public class ChatClientLoginListener implements ChatEventListener {

    @Override
    public void listen(String base64, PrintWriter writer) {
        writer.println(base64);
    }

}

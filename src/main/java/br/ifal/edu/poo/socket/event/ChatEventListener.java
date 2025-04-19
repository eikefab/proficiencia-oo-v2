package br.ifal.edu.poo.socket.event;

import br.ifal.edu.poo.socket.ChatClient;

import java.io.PrintWriter;

public interface ChatEventListener {

    void listen(ChatClient client, String base64, PrintWriter writer);

}

package br.ifal.edu.poo.socket.event;

import java.io.PrintWriter;

public interface ChatEventListener {

    void listen(String base64, PrintWriter writer);

}

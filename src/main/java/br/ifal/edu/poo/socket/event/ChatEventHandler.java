package br.ifal.edu.poo.socket.event;

import br.ifal.edu.poo.socket.ChatClient;
import br.ifal.edu.poo.socket.listener.ChatClientLoginListener;
import br.ifal.edu.poo.socket.listener.ChatClientRegisterListener;

import java.util.HashMap;
import java.util.Map;

public record ChatEventHandler(ChatClient client) {

    public static final String EVENT_DATA_SEPARATOR = "::";
    private static final Map<ChatEvent, ChatEventListener> LISTENERS = new HashMap<>();

    static {
        LISTENERS.put(ChatEvent.LOGIN, new ChatClientLoginListener());
        LISTENERS.put(ChatEvent.REGISTER, new ChatClientRegisterListener());
    }

    public ChatEventListener getListener(ChatEvent event) {
        return LISTENERS.get(event);
    }

}

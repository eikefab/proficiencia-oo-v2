package br.ifal.edu.poo.socket.auth;

import br.ifal.edu.poo.entities.User;
import br.ifal.edu.poo.socket.ChatClient;

import java.util.Map;
import java.util.WeakHashMap;

public final class AuthController {

    private static final Map<User, ChatClient> AUTH_SOCKETS = new WeakHashMap<>();

    private AuthController() {}

    public static void add(User user, ChatClient client) {
        AUTH_SOCKETS.put(user, client);
    }

    public static boolean hasSession(User user) {
        return AUTH_SOCKETS.containsKey(user);
    }

    public static ChatClient getClient(User user) {
        return AUTH_SOCKETS.get(user);
    }

    public static void logout(User user) {
        AUTH_SOCKETS.remove(user);
    }

}

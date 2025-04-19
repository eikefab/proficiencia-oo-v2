package br.ifal.edu.poo.socket.listener;

import br.ifal.edu.poo.controllers.UserController;
import br.ifal.edu.poo.controllers.impl.UserControllerImpl;
import br.ifal.edu.poo.entities.User;
import br.ifal.edu.poo.exceptions.server.ServerInvalidRequestException;
import br.ifal.edu.poo.exceptions.user.UserEmailAlreadyExistsException;
import br.ifal.edu.poo.exceptions.user.UserPasswordInvalidException;
import br.ifal.edu.poo.socket.ChatClient;
import br.ifal.edu.poo.socket.auth.AuthController;
import br.ifal.edu.poo.socket.event.ChatEventListener;

import java.io.PrintWriter;

public class ChatClientRegisterListener implements ChatEventListener {

    private final UserController controller;

    public ChatClientRegisterListener() {
        this.controller = UserControllerImpl.getInstance();
    }

    @Override
    public void listen(ChatClient client, String base64, PrintWriter writer) {
        final String[] items = base64.split(",");

        if (items.length != 2) {
            throw new ServerInvalidRequestException();
        }

        final String email = items[0];
        final String password = items[1];

        try {
            final User user = controller.register(email, password);

            writer.println("success::register_" + user.getUniqueId());

            AuthController.add(user, client);
        } catch (UserEmailAlreadyExistsException exception) {
            writer.println("error::email_registered");
        } catch (UserPasswordInvalidException exception) {
            writer.println("error:invalid_password");
        }
    }

}

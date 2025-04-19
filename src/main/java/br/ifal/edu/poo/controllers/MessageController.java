package br.ifal.edu.poo.controllers;

import br.ifal.edu.poo.entities.Group;
import br.ifal.edu.poo.entities.Message;
import br.ifal.edu.poo.entities.User;
import br.ifal.edu.poo.exceptions.group.GroupNotFoundException;
import br.ifal.edu.poo.exceptions.message.MessageInvalidContentException;
import br.ifal.edu.poo.exceptions.message.MessageInvalidTargetException;
import br.ifal.edu.poo.exceptions.user.UserNotFoundException;

import java.util.List;
import java.util.Map;

public interface MessageController {

    void sendMessage(User author, User target, String content) throws UserNotFoundException, MessageInvalidContentException, MessageInvalidTargetException;
    void sendMessage(User author, String content, Group group) throws UserNotFoundException, GroupNotFoundException, MessageInvalidContentException;

    Map<User, List<Message>> retrieveMessages(User author) throws UserNotFoundException;

    List<Message> retrieveChat(User author, User target) throws UserNotFoundException, MessageInvalidTargetException;
    List<Message> retrieveChat(Group group) throws GroupNotFoundException;

}

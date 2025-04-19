package br.ifal.edu.poo.repository;

import br.ifal.edu.poo.entities.Group;
import br.ifal.edu.poo.entities.Message;
import br.ifal.edu.poo.entities.User;

import java.util.Set;

public interface MessageRepository {

    void create(Message message);
    void create(Message message, Group group);

    Set<Message> fetchMessages(User author, User target);
    Set<Message> fetchMessages(Group group);

}

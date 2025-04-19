package br.ifal.edu.poo.entities;

import java.util.UUID;

public class Message {

    private final UUID uniqueId;
    private final UUID sentBy;
    private final UUID sentTo;
    private final long sentAtMillis;
    private final String content;

    public Message(MessageBuilder builder) {
        this.uniqueId = builder.getUniqueId();
        this.sentBy = builder.getSentBy();
        this.sentTo = builder.getSentTo();
        this.sentAtMillis = builder.getSentAtMillis();
        this.content = builder.getContent();
    }

    public String getContent() {
        return content;
    }

    public long getSentAtMillis() {
        return sentAtMillis;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public UUID getSentTo() {
        return sentTo;
    }

    public UUID getSentBy() {
        return sentBy;
    }

}

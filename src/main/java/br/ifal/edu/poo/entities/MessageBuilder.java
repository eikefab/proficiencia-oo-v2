package br.ifal.edu.poo.entities;

import java.util.UUID;

public class MessageBuilder {

    public static MessageBuilder newInstance() {
        return new MessageBuilder();
    }

    private UUID uniqueId;
    private long sentAtMillis;

    private UUID sentTo;
    private UUID sentBy;
    private UUID groupId;
    private String content;

    public MessageBuilder() {
        this.uniqueId = UUID.randomUUID();
        this.sentAtMillis = System.currentTimeMillis();
    }

    public MessageBuilder uniqueId(UUID id) {
        this.uniqueId = id;

        return this;
    }

    private MessageBuilder sentTo(UUID id) {
        this.sentTo = id;

        return this;
    }

    private MessageBuilder sentTo(User target) {
        return sentTo(target.getUniqueId());
    }

    private MessageBuilder sentBy(UUID id) {
        this.sentBy = id;

        return this;
    }

    private MessageBuilder sentBy(User author) {
        return sentBy(author.getUniqueId());
    }

    public MessageBuilder groupId(UUID id) {
        this.groupId = id;

        return this;
    }

    public MessageBuilder content(String content) {
        this.content = content;

        return this;
    }

    public MessageBuilder sentAtMillis(long sentAtMillis) {
        this.sentAtMillis = sentAtMillis;

        return this;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public long getSentAtMillis() {
        return sentAtMillis;
    }

    public UUID getSentBy() {
        return sentBy;
    }

    public UUID getSentTo() {
        return sentTo;
    }

    public String getContent() {
        return content;
    }

    public UUID getGroupId() {
        return groupId;
    }
}

package br.ifal.edu.poo.socket.event;

public enum ChatEvent {

    REGISTER("register_client_event"),
    LOGIN("login_client_event");

    private final String eventId;

    ChatEvent(String eventId) {
        this.eventId = eventId;
    }

    public String getEventId() {
        return eventId;
    }

    public static ChatEvent stripEvent(String socketInput) {
        final String[] data = socketInput.split(ChatEventHandler.EVENT_DATA_SEPARATOR);

        if (data.length != 2) {
            return null;
        }

        final String trigger = data[0];

        for (ChatEvent event : values()) {
            if (event.getEventId().equals(trigger)) {
                return event;
            }
        }

        return null;
    }

}

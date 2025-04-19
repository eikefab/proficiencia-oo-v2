package br.ifal.edu.poo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {

    public static final int MAX_CAPACITY = 5; // capacidade máxima de cada grupo

    private final UUID uniqueId;
    private final String name;
    private final UUID administratorId;
    private final List<UUID> participantsId;

    public Group(GroupBuilder builder) {
        this.uniqueId = builder.getUniqueId();
        this.name = builder.getName();
        this.administratorId = builder.getAdministratorId();
        this.participantsId = builder.getParticipantsId();
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }

    public UUID getAdministratorId() {
        return administratorId;
    }

    public List<UUID> getParticipantsId() {
        return new ArrayList<>(participantsId);
    }

}

package br.ifal.edu.poo.entities;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class GroupBuilder {

    public static GroupBuilder newInstance() {
        return new GroupBuilder();
    }

    private UUID uniqueId;
    private UUID administratorId;
    private List<UUID> participantsId;
    private String name;

    public GroupBuilder() {
        this.uniqueId = UUID.randomUUID();
    }


    public GroupBuilder uniqueId(UUID id) {
        this.uniqueId = id;

        return this;
    }

    public GroupBuilder administratorId(UUID id) {
        this.administratorId = id;

        return this;
    }

    public GroupBuilder participants(UUID... ids) {
        this.participantsId = Arrays.asList(ids);

        return this;
    }

    public GroupBuilder name(String name) {
        this.name = name;

        return this;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public UUID getAdministratorId() {
        return administratorId;
    }

    public List<UUID> getParticipantsId() {
        return participantsId;
    }

    public String getName() {
        return name;
    }
}


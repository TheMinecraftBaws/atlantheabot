package net.atlanthea.themcbaws.abot.functions;

import net.atlanthea.themcbaws.abot.reference.Constants;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Collection;
import java.util.List;

public class Roles {


    public Roles(MessageReceivedEvent event, String role) {
        Roles(event, role);
    }

    public List Roles (MessageReceivedEvent event, String role) {
        List calledRole = event.getJDA().getRolesByName(role, true);
        return calledRole;
    }
}

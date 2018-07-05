package net.atlanthea.themcbaws.abot.functions.commands;

import net.atlanthea.themcbaws.abot.reference.Variables;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Debug {
    public Debug(MessageReceivedEvent event) {
        String id = event.getAuthor().getId();
        if (!(id.equals(Variables.adminId))) {
            String name = "<@" + id + ">";
            String response = name + ", you are not an Admin!";
            event.getMessage().getTextChannel().sendMessage(response).queue();
        }
        else {
            String name = "<@" + id + ">";
            String response = name + ", check your dms!";
            event.getMessage().getTextChannel().sendMessage(response).queue();
        }
    }
}
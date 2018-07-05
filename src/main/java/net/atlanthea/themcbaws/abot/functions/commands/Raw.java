package net.atlanthea.themcbaws.abot.functions.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Raw {
    public Raw(MessageReceivedEvent event) {
        String id = event.getAuthor().getId();
        String name = "<@" + id + ">";
        String response =  name + ", this is the base command! Do !help to see the commands and their usage";
        event.getMessage().getTextChannel().sendMessage(response).queue();
        System.out.println("Guild member " + event.getAuthor().getName() + " used the base command!");
    }
}

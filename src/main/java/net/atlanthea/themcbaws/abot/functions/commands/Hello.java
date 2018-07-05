package net.atlanthea.themcbaws.abot.functions.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Hello {
public Hello (MessageReceivedEvent event) {
    String id = event.getAuthor().getId();
    String name = "<@" + id + ">";
    String response =  name + ", hello!";
    event.getMessage().getTextChannel().sendMessage(response).queue();
}

}

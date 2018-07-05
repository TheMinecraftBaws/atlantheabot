package net.atlanthea.themcbaws.abot.functions.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Guild {
public Guild(MessageReceivedEvent event) {
    String id = event.getAuthor().getId();
    String name = "<@" + id + ">";
    String response =  name + ", this is the guild command for now, it will have info about this guild!";
    event.getMessage().getTextChannel().sendMessage(response).queue();

}
}

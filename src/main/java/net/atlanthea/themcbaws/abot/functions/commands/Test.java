package net.atlanthea.themcbaws.abot.functions.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Test {
    public Test (MessageReceivedEvent event) {
        event.getChannel().sendMessage("You done boofed erik.").queue();
    }
}

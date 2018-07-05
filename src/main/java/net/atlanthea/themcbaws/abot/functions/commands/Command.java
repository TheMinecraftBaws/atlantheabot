package net.atlanthea.themcbaws.abot.functions.commands;

import net.atlanthea.themcbaws.abot.reference.Variables;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Command {
    public static String name = "command";
    public static String usage = Variables.botPrefix + "command" + "<args>+";
    public static String desc = "Description of command";
public Command (MessageReceivedEvent event) {
    event.getMessage().getTextChannel().sendMessage("Hello, this is a command");
}
}

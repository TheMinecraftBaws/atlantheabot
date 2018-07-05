package net.atlanthea.themcbaws.abot.functions.commands;

import net.atlanthea.themcbaws.abot.reference.Commands;
import net.atlanthea.themcbaws.abot.reference.Variables;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Help {
    private static String arrayToString(String[] array) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= array.length - 1; i++) {
            String item = array[i];
            sb.append(item);
        }
        return sb.toString();




    }
    public Help(MessageReceivedEvent event) {


        String help[] = new String[Commands.COMMANDS.length];
        {
            for (int i = 0; i <= Commands.COMMANDS.length - 1; i++) {
                help[i] = Variables.botPrefix + Commands.COMMANDS[i] + ": " + Commands.USAGE[i] + "\n";
            }
            String helpMessage = arrayToString(help);

            String id = event.getAuthor().getId();
            String name = "<@" + id + ">";
            String response = name + ", here is the commands and their usage: \n" + helpMessage;
            event.getMessage().getTextChannel().sendMessage(response).queue();
        }
    }
}
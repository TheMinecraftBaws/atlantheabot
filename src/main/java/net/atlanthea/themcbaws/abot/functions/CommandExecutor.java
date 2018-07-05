package net.atlanthea.themcbaws.abot.functions;
import net.atlanthea.themcbaws.abot.reference.Variables;
import net.dv8tion.jda.core.events.message.*;
import net.atlanthea.themcbaws.abot.reference.Commands;
public class CommandExecutor {
    public CommandExecutor(String s, MessageReceivedEvent event) {
        int counter = 0;
        String args[] = s.split("[! ]", 2);
        for (String c : Commands.COMMANDS) {
            if (c.contains(args[0])) {
                try {
                    new MessageResponder(c, event);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                break;

            }
            counter++;
        }
        if (counter == Commands.COMMANDS.length) {
            String id = event.getAuthor().getId();
            String name = "<@" + id + ">";
            String response =  name + ", there is no such command! Do !help";
            event.getMessage().getTextChannel().sendMessage(response).queue();
            System.out.println(event.getAuthor().getName() + " tried to use " + Variables.botPrefix + args[0]);
        }


    }
}
package net.atlanthea.themcbaws.abot.listeners;

import net.atlanthea.themcbaws.abot.functions.CommandExecutor;
import net.atlanthea.themcbaws.abot.functions.Roles;
import net.atlanthea.themcbaws.abot.reference.Variables;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.events.message.*;


public class MessageEvent extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (message.startsWith(Variables.botPrefix)) {

            new CommandExecutor(message.substring(1), event);
        }
    }
}
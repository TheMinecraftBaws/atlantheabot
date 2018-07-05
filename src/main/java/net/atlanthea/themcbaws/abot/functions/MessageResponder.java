package net.atlanthea.themcbaws.abot.functions;

import net.atlanthea.themcbaws.abot.functions.commands.Raw;
import net.atlanthea.themcbaws.abot.reference.Variables;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;
import java.util.Objects;


class MessageResponder {
    public MessageResponder(String c, MessageReceivedEvent event) throws NoSuchMethodException, StringIndexOutOfBoundsException {
        if (c.length() == 0) {
            new Raw(event);
        } else {
            try {

                String output = c.substring(0, 1).toUpperCase() + c.substring(1);

                Constructor commandConstructor = null;
                String outputPackage = "net.atlanthea.themcbaws.abot.functions.commands." + output;
                Class eve = MessageReceivedEvent.class;

                try {
                    Class aClass = Class.forName(outputPackage);
                    commandConstructor = aClass.getDeclaredConstructor(eve);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                Objects.requireNonNull(commandConstructor).newInstance(event);
                System.out.println("Guild member " + event.getAuthor().getName() + " used the " + Variables.botPrefix + c + " command!");
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }

        }
    }
}
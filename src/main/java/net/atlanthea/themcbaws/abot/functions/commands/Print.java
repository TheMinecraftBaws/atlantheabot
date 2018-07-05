package net.atlanthea.themcbaws.abot.functions.commands;

import net.atlanthea.themcbaws.abot.functions.Roles;
import net.atlanthea.themcbaws.abot.reference.Constants;
import net.atlanthea.themcbaws.abot.reference.Variables;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Print {
    public Print(MessageReceivedEvent event) {
        List userRoles = event.getGuild().getMember(event.getAuthor()).getRoles();
        List allowedRoles = new ArrayList();
        List admin = event.getJDA().getRolesByName("admin", true);
        allowedRoles.addAll(admin);
        List seniorAdmin = event.getJDA().getRolesByName("senior-admin", true);
        allowedRoles.addAll(seniorAdmin);
        List headAdmin = event.getJDA().getRolesByName("lead-admin", true);
        allowedRoles.addAll(headAdmin);
        List secretary = event.getJDA().getRolesByName("secretary", true);
        allowedRoles.addAll(secretary);
        List director = event.getJDA().getRolesByName("director", true);
        allowedRoles.addAll(director);
        List owner = event.getJDA().getRolesByName("owner", true);
        allowedRoles.addAll(owner);

        String message = event.getMessage().getContentRaw();
        String args = message.substring(6);
        TextChannel staff = event.getGuild().getTextChannelsByName("staff-announcements", true).get(0);
        TextChannel general = event.getGuild().getTextChannelsByName("announcements", true).get(0);
        if (!Collections.disjoint(userRoles, allowedRoles)) {
            if (args.length() == 0) {
                EmbedBuilder embedBuilder = new EmbedBuilder().setTitle("Command Error").setColor(Constants.RED)
                        .setDescription("Please specify arguments; " + Variables.botPrefix + "print <channel> %message%")
                        .setFooter("Silly " + event.getAuthor().getName(), null);
                event.getTextChannel().sendMessage(embedBuilder.build()).queue();

            } else {

                String args1 = args.substring(1);

                if (args1.startsWith("general")) {
                    String process1 = args.replace("%e%", "@everyone");
                    String process2 = process1.replace("%h%", "@here");
                    EmbedBuilder embedBuilder = new EmbedBuilder().setTitle("Staff Announcement").setColor(Constants.BLUE)
                            .setDescription(process2.substring(8))
                            .setFooter("Announcement called by: " + event.getAuthor().getName(), null);
                    String mention = null;
                    if (process2.contains("@here") && process2.contains("@everyone")) {
                        mention = "@everyone";
                    }
                    else if (process2.contains("@here") && !(process2.contains("@everyone"))) {
                        mention = "@here";
                    }
                    if (!(process2.contains("@here")) && process2.contains("@everyone")) {
                        mention = "@everyone";
                    }
                    general.sendMessage(mention).queue();
                    general.sendMessage(embedBuilder.build()).queue();
                } else if (args1.startsWith("staff")) {
                    String process1 = args.replace("%e%", "@everyone");
                    String process2 = process1.replace("%h%", "@here");
                    EmbedBuilder embedBuilder = new EmbedBuilder().setTitle("Announcement").setColor(Constants.BLUE)
                            .setDescription(process2.substring(6))
                            .setFooter("Announcement called by: " + event.getAuthor().getName(), null);
                    String mention = null;
                    if (process2.contains("@here") && process2.contains("@everyone")) {
                        mention = "@everyone";
                    }
                    else if (process2.contains("@here") && !(process2.contains("@everyone"))) {
                        mention = "@here";
                    }
                    if (!(process2.contains("@here")) && process2.contains("@everyone")) {
                        mention = "@everyone";
                    }
                    staff.sendMessage(mention).queue();
                    staff.sendMessage(embedBuilder.build()).queue();
                } else {
                    EmbedBuilder embedBuilder = new EmbedBuilder().setTitle("Command Error").setColor(Constants.RED)
                            .setDescription("Invalid channel arguments, try:  " + Variables.botPrefix + "print <channel> %message%")
                            .setFooter("Silly " + event.getAuthor().getName(), null);
                    event.getTextChannel().sendMessage(embedBuilder.build()).queue();
                }

            }
        }
        else {
            EmbedBuilder embedBuilder = new EmbedBuilder().setTitle("Permission error").setColor(Constants.RED)
                    .setDescription("You do not have permission to use this command")
                    .setFooter("Silly " + event.getAuthor().getName(), null);
            event.getTextChannel().sendMessage(embedBuilder.build()).queue();
        }
    }
}
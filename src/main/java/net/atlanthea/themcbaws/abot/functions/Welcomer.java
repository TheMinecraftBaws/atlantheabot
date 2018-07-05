package net.atlanthea.themcbaws.abot.functions;

import net.atlanthea.themcbaws.abot.reference.Constants;
import net.atlanthea.themcbaws.abot.reference.Variables;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;

public class Welcomer {
    public Welcomer(GuildMemberJoinEvent event) {
        if (!event.getUser().isBot() && !event.getUser().isBot()) {
            User eventUser = event.getUser();
            String iD = eventUser.getId();
            String username = "<@" + iD + ">";
            Integer memberCount = 0;
            for (Member member : event.getGuild().getMembers()) {
                if (!member.getUser().isBot() && !member.getUser().isFake()) {
                    memberCount++;
                }
            }
            String footerText = "There are now " + memberCount + " members.";
            Integer membersToGo = 100 - memberCount;
            if (membersToGo > 0) {
                if (membersToGo == 1) {
                    footerText = footerText + " (" + membersToGo + " more member until 100!)";
                } else {
                    footerText = footerText + " (" + membersToGo + " more members until 100.)";
                }
            } else if (membersToGo > 0) {
                membersToGo = membersToGo * -1;
                if (membersToGo == 1) {
                    footerText = footerText + " (We now have " + membersToGo + " more member than 100!)";
                } else {
                    footerText = footerText + " (We now have " + membersToGo + " more members than 100!)";
                }
            } else {
                footerText = footerText + " (We've hit 100 members! :tada: )";
            }
            if (event.getGuild().getTextChannelsByName(Variables.welcomeMessageChannel, true).size() > 0) {
                TextChannel welcomeChannel = event.getGuild().getTextChannelsByName(Variables.welcomeMessageChannel, true).get(0);

                EmbedBuilder embedBuilder = new EmbedBuilder().setTitle("User Join").setColor(Constants.GREEN)
                        .setDescription("Welcome " + username + " to the Atlanthea Minecraft Discord.")
                        .setFooter(footerText, null);
                welcomeChannel.sendMessage(embedBuilder.build()).queue();

            }
        }
    }

}

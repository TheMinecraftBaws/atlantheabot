package net.atlanthea.themcbaws.abot.listeners;

import net.atlanthea.themcbaws.abot.functions.Goodbye;
import net.atlanthea.themcbaws.abot.functions.Welcomer;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class JoinLeaveEvent extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        new Welcomer(event);
    }
    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
        new Goodbye(event);
            }
        }
package com.makerzip.template.commands;

import com.makerzip.template.Config;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

/**
 * @author MakerZip (juwon@makerzip.com)
 */
public class Invite extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (message.equalsIgnoreCase(Config._prefix + "초대")) {
            String ficon = event.getJDA().getUserById(Config.owner_id).getAvatarUrl();
            String ftext = event.getJDA().getUserById(Config.owner_id).getAsTag();
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(Color.decode("0xf3b3bc"));
            embed.setTitle("TemplateBot 초대하기", "https://discord.com/oauth2/authorize?client_id=" + "" + "&permissions=2147483647&scope=bot");
            embed.setFooter(ftext, ficon);
            event.getChannel().sendMessage(embed.build()).queue();
        }
    }
}

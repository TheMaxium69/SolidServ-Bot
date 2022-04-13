package fr.maxime.bot;

import fr.maxime.bot.cmd.debug;
import fr.maxime.bot.cmd.exemple;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class command {
    public static void init(String request, MessageChannel channel, User user, Guild guild, Message messageRaw, MessageReceivedEvent event){

        /*help*/
        if (request.contains("help")){ exemple.Help(channel); }

        /*admin*/
        if (request.contains("admin") && user.getId().equals(env.userAdmin)){ exemple.Admin(channel, user.getAsTag()); }


        /*New Command*/
//      if (request.contains("exemple")){ exemple.Exemple(exemple); }


        /*debug*/
        if (request.contains("debug")){ debug.Debug(channel, guild.getName() ,user.getAsTag()); }

        /*me*/
        if (request.contains("me")){ debug.Moi(channel, user.getAsTag()); }

        /*chan*/
        if (request.contains("chan")){ debug.Channel(channel); }

        /*serv*/
        if (request.contains("serv")){ debug.Serv(channel, guild, false); }

        /*countserv*/
        if (request.contains("count")){ debug.Serv(channel, guild, true); }
    }
}

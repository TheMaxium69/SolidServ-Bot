package fr.maxime.bot.cmd;

import fr.maxime.bot.system.app;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;

public class debug
{
    public static void Debug(MessageChannel chanelEvent, String guildName, String userTag){
        String message = guildName + " / " + chanelEvent.getName() + " / " + userTag;
        app.send(chanelEvent, message);
    }

    public static void Moi(MessageChannel chanelEvent, String userTag){
        String message = "you are ``" + userTag + "``";
        app.send(chanelEvent, message);
    }

    public static void Channel(MessageChannel chanelEvent){
        String message = "you are in the channel  ``" + chanelEvent.getName() + "``";
        app.send(chanelEvent, message);
    }

    public static void Serv(MessageChannel chanelEvent, Guild guildEvent, Boolean isCount){
        String message = null;
        if (isCount){
            message = "there are  ``" + guildEvent.getMemberCount() + "`` people in ``" + guildEvent.getName() + "``";
        }else {
            message = "you are in the server ``" + guildEvent.getName() + "``";
        }
        app.send(chanelEvent, message);
    }
}

package fr.maxime.bot.system;

import fr.maxime.bot.env;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class app {

    public static Boolean System(String date, String guildName, String channelName, String userTag, String msgRaw){
        String Line = date + " | " + guildName + " / " + channelName;
        String Linelog = " / " + userTag + " ----> " + msgRaw;

        Boolean isCmd = MessagePrefix(msgRaw);
        if (isCmd){
            Log(Line + Linelog, Line + " <Request Perform>");
        }
        return isCmd;
    }

    public static void Log(String Linelog, String LineRequest){
        System.out.println(Linelog);
        System.out.println(LineRequest);
    }

    public static boolean MessagePrefix(String msgRaw){
        try {
            String cmd = msgRaw.substring(0, 2);

            if (cmd.toLowerCase().equals(env.prefix)){
                return true;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return false;
    }

    public static void send(MessageChannel channel, String message){
        channel.sendMessage(message).queue();
    }

    public static void sendEmbed(MessageChannel channel, MessageEmbed message){
        channel.sendMessage(message).queue();
    }

    public static String get(String url) throws IOException {
        String source ="";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            source +=inputLine;
        in.close();
        return source;
    }
}

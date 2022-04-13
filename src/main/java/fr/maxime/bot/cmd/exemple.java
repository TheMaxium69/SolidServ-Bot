package fr.maxime.bot.cmd;

import fr.maxime.bot.env;
import fr.maxime.bot.system.app;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

public class exemple {

    public static void Help(MessageChannel channel){

        String description =
                "-Exemple\n" + "\n"
                + "["+ env.prefix +"] help = this command \n"
                + "["+ env.prefix +"] admin = command only for <@!"+ env.userAdmin +"> \n"
                + "\n" + "-Debug\n" + "\n"
                + "["+ env.prefix +"] debug = to see the debug\n"
                + "["+ env.prefix +"] me = the command to know who you are\n"
                + "["+ env.prefix +"] chan = the command to know in which channel you are\n"
                + "["+ env.prefix +"] serv = the command to know which server you are in\n"
                + "["+ env.prefix +"] count = the command to know the number of people in the server that you are\n";


        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(8191);
        embed.setTitle("Commande Help");
        embed.setDescription(description);
        app.sendEmbed(channel ,embed.build());
    }

    public static void Admin(MessageChannel channel, String userTag){
        String message = "tu a bien les perms pour cette commande ``" + userTag + "``";
        app.send(channel, message);
    }
}

package fr.maxime.bot.system;

import fr.maxime.bot.env;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.annotation.Nonnull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class message extends ListenerAdapter {
    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        Message eventMsg = event.getMessage();
        MessageChannel eventChannel = event.getChannel();
        Guild eventGuild = event.getGuild();
        User eventUser = event.getAuthor();
        String eventDate = new SimpleDateFormat("dd/MM HH:mm").format(Calendar.getInstance().getTime());

        if(eventChannel.getId().equals(env.chanAnnId)){

            System.out.println(eventMsg.getContentRaw());
            String msgRow = eventMsg.getContentRaw();
            String msgRowEdit = msgRow.replace(" ", "%20");

            System.out.println("*********");

            Scanner scan = new Scanner(msgRowEdit);
            String msgRowLine = "";

            int i = 1;
            int j = 1;
            while (i < 6) {
                boolean line = scan.hasNextLine();

                if (line){
                    if (j == 1){
                        msgRowLine = scan.nextLine();
                    } else {
                        msgRowLine = msgRowLine + "%0D%0A" + scan.nextLine();
                    }

                } else {
                    i = 7;
                }

                j++;

            }

            System.out.println(msgRowLine);

            try {
                String test = sendRequest("http://localhost/api.php?param1=" + msgRowLine);
                System.out.println(test);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    static String sendRequest(String url) throws IOException {
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

package fr.maxime.bot.system;

import fr.maxime.bot.command;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.annotation.Nonnull;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class message extends ListenerAdapter {
    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        Message eventMsg = event.getMessage();
        MessageChannel eventChannel = event.getChannel();
        Guild eventGuild = event.getGuild();
        User eventUser = event.getAuthor();
        String eventDate = new SimpleDateFormat("dd/MM HH:mm").format(Calendar.getInstance().getTime());
        Boolean isCmd = app.System(eventDate, eventGuild.getName(), eventChannel.getName(), eventUser.getAsTag(), eventMsg.getContentRaw());
        if (isCmd) { command.init(eventMsg.getContentRaw().toLowerCase().substring(2), eventChannel, eventUser, eventGuild, eventMsg, event); }
    }
}

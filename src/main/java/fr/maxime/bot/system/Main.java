package fr.maxime.bot.system;

import fr.maxime.bot.env;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] argv) throws LoginException {
        System.out.println("BOT = Initialization");
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(env.token);
        builder.addEventListeners(new message());
        builder.setActivity(Activity.playing(env.playing));
        builder.build();
        System.out.println("BOT = Ready");
    }
}

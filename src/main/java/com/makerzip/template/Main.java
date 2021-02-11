package com.makerzip.template;

import com.makerzip.template.commands.Invite;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author MakerZip (juwon@makerzip.com)
 */
public class Main {
    public static void main(String[] args) throws LoginException {
        String[] ChangeActivity = {Config._prefix + "초대",Config._prefix + "도움"};
        int ChangeDelay = 10; //최소 10초이상을 추천

        JDA jda = new JDABuilder(AccountType.BOT)
                .setToken(new Config().token(false))
                .setStatus(OnlineStatus.ONLINE)
                .build();

        jda.addEventListener(new Invite());

        final int[] currentIndex = {0};
        new Timer().schedule(new TimerTask() {
            public void run() {
                jda.getPresence().setActivity(Activity.playing(ChangeActivity[currentIndex[0]]));
                currentIndex[0] = (currentIndex[0] + 1) % ChangeActivity.length;
            }
        }, 0, ChangeDelay + 000);
    }
}

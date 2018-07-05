package net.atlanthea.themcbaws.abot.main;

import net.atlanthea.themcbaws.abot.listeners.JoinLeaveEvent;
import net.atlanthea.themcbaws.abot.listeners.MessageEvent;
import net.atlanthea.themcbaws.abot.reference.Variables;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import static javax.measure.unit.SI.KILOGRAM;
import javax.measure.quantity.Mass;
import org.jscience.physics.model.RelativisticModel;
import org.jscience.physics.amount.Amount;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.Map;
import java.util.Properties;


public class Main {

    static JDA discord;
    @RequestMapping("/hello")
    String hello(Map<String, Object> model) {
        RelativisticModel.select();
        Amount<Mass> m = Amount.valueOf("12 GeV").to(KILOGRAM);
        model.put("science", "E=mc^2: 12 GeV = " + m.toString());
        return "hello";
    }
    public static void main(String args[]) throws Exception {

        System.out.println("\n");
        String botPropertiesFileName = "abot.properties";
        Properties prop = new Properties();
        File botPropertiesFile = new File(botPropertiesFileName);
        if (!(botPropertiesFile.exists())) {

            botPropertiesFile.createNewFile();
            PrintWriter botPropertiesFileWriter = new PrintWriter(botPropertiesFileName);
            botPropertiesFileWriter.print("# ABot config:\ntoken=PUT YOUR TOKEN HERE");
            botPropertiesFileWriter.close();
            System.out.println("Bot error, config file did not contain bot token");
        } else {
            InputStream botPropertiesInput = new FileInputStream(botPropertiesFileName);
            prop.load(botPropertiesInput);
            if (prop.containsKey("token") && prop.getProperty("token").equalsIgnoreCase("PUT YOUR TOKEN HERE")) {
                System.out.println("The token is not set");
                System.exit(0);

            }
            String token = prop.getProperty("token");
            discord = new JDABuilder(AccountType.BOT).setToken(token).setGame(Game.playing("play.atlanthea.net| " + Variables.botPrefix + "help")).buildBlocking();
            discord.addEventListener(new JoinLeaveEvent(), new MessageEvent());

        }
    }

    }
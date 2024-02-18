package edu.java.scrapper.coreApp;

import com.pengrad.telegrambot.model.BotCommand;
import java.util.List;

public interface CommandHandler {
    String getAnswer(String text, String user);

    List<BotCommand> getCommandsMenu();
}

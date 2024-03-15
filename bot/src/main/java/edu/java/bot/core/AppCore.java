package edu.java.bot.core;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SetMyCommands;
import java.util.logging.Logger;

public class AppCore {

    Logger logger = Logger.getLogger("AppCore");
    CommandHandler commandHandler = new MainHandler();
    private final String token;

    public AppCore(String token) {
        this.token = token;
    }

    public void eventUpdate() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new SetMyCommands(getCommands()));

        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                if (update.message() != null) {
                    Message message = update.message();
                    long chatId = message.chat().id();
                    String text = message.text();

                    String user = "dummy";
                    bot.execute(new SendMessage(chatId, commandHandler.getAnswer(text, user)));
                }
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }, e -> {
            if (e.response() != null) {
                e.response().errorCode();
                e.response().description();
            } else {
                logger.warning(e.getMessage());
            }
        });
    }

    private BotCommand[] getCommands() {
        return commandHandler.getCommandsMenu().toArray(BotCommand[]::new);
    }
}

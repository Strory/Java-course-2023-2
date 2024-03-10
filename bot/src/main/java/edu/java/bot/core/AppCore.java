package edu.java.bot.core;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SetMyCommands;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import java.util.List;
import java.util.logging.Logger;

public class AppCore {

    Logger logger = Logger.getLogger("AppCore");
    CommandHandler commandHandler = new MainHandler();
    private final String token;

    public AppCore(String token) {
        this.token = token;
    }

    public void startCore() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new SetMyCommands(getCommands()));

        startMainCycle(bot);
    }

    @SuppressWarnings("MagicNumber")
    private void startMainCycle(TelegramBot bot) {
        int lastUpdateId = 0;
        while (true) {
            GetUpdates getUpdates = new GetUpdates().limit(100).offset(lastUpdateId + 1).timeout(0);
            GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
            List<Update> updates = updatesResponse.updates();

            for (Update update : updates) {
                if (update.message() != null) {
                    Message message = update.message();
                    long chatId = message.chat().id();
                    String text = message.text();

                    String user = "dummy";
                    bot.execute(new SendMessage(chatId, commandHandler.getAnswer(text, user)));
                    lastUpdateId = update.updateId();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.warning(e.getMessage());
            }
        }
    }

    private BotCommand[] getCommands() {
        return commandHandler.getCommandsMenu().toArray(BotCommand[]::new);
    }
}

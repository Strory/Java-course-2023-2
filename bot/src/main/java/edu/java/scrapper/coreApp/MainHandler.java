package edu.java.scrapper.coreApp;

import com.pengrad.telegrambot.model.BotCommand;
import java.util.ArrayList;
import java.util.List;

public class MainHandler implements CommandHandler{
    private final String START_COMMAND = "/start";
    private final String HELP_COMMAND = "/help";
    private final String TRACK_COMMAND = "/track";
    private final String UNTRACK_COMMAND = "/untrack";
    private final String LIST_COMMAND = "/list";

    public MainHandler(){}

    @Override
    public String getAnswer(String text, String user) {
        return switch (text) {
            case "/start" -> "start command";
            case "/help" -> help_command();
            case "/track" -> "track command";
            case "/untrack" -> "untrack command";
            case "/list" -> "list command";
            default -> "bad request";
        };
    }

    @Override
    public List<BotCommand> getCommandsMenu() {
        List<BotCommand> commands = new ArrayList<>();
        commands.add(new BotCommand(START_COMMAND, "registration"));
        commands.add(new BotCommand(HELP_COMMAND, "available commands"));
        commands.add(new BotCommand(TRACK_COMMAND, "start tracking"));
        commands.add(new BotCommand(UNTRACK_COMMAND, "stop tracking"));
        commands.add(new BotCommand(LIST_COMMAND, "watch list"));
        return commands;
    }

    private String help_command() {
        return START_COMMAND + " " + "registration" + "\n"
            + HELP_COMMAND + " " + "available commands" + "\n"
            + TRACK_COMMAND + " " + "start tracking" + "\n"
            + UNTRACK_COMMAND + " " + "stop tracking" + "\n"
            + LIST_COMMAND + " " + "watch list" + "\n";
    }
}

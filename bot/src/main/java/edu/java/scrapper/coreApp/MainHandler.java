package edu.java.scrapper.coreApp;

import com.pengrad.telegrambot.model.BotCommand;
import java.util.ArrayList;
import java.util.List;

public class MainHandler implements CommandHandler {
    private final String startCommand = "/start";
    private final String helpCommand = "/help";
    private final String trackCommand = "/track";
    private final String untrackCommand = "/untrack";
    private final String listCommand = "/list";

    public MainHandler() {}

    @Override
    public String getAnswer(String text, String user) {
        return switch (text) {
            case startCommand -> "start command";
            case helpCommand -> getHelp();
            case trackCommand -> "track command";
            case untrackCommand -> "untrack command";
            case listCommand -> "list command";
            default -> "bad request";
        };
    }

    @SuppressWarnings("MultipleStringLiterals")
    @Override
    public List<BotCommand> getCommandsMenu() {
        List<BotCommand> commands = new ArrayList<>();
        commands.add(new BotCommand(startCommand, "registration"));
        commands.add(new BotCommand(helpCommand, "available commands"));
        commands.add(new BotCommand(trackCommand, "start tracking"));
        commands.add(new BotCommand(untrackCommand, "stop tracking"));
        commands.add(new BotCommand(listCommand, "watch list"));
        return commands;
    }

    @SuppressWarnings("MultipleStringLiterals")
    private String getHelp() {
        return startCommand + " " + "registration" + "\n"
            + helpCommand + " " + "available commands" + "\n"
            + trackCommand + " " + "start tracking" + "\n"
            + untrackCommand + " " + "stop tracking" + "\n"
            + listCommand + " " + "watch list" + "\n";
    }
}

package edu.java.bot.core;

import com.pengrad.telegrambot.model.BotCommand;
import edu.java.bot.core.commands.Command;
import edu.java.bot.core.commands.DummyCommand;
import edu.java.bot.core.commands.HelpCommand;
import edu.java.bot.core.commands.ListCommand;
import edu.java.bot.core.commands.StartCommand;
import edu.java.bot.core.commands.TrackCommand;
import edu.java.bot.core.commands.UntrackCommand;
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
        Command list = new ListCommand(new DummyCommand(null));
        Command untrack = new UntrackCommand(list);
        Command track = new TrackCommand(untrack);
        Command help = new HelpCommand(track);
        Command start = new StartCommand(help);

        return start.getAnswer(text);
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
}

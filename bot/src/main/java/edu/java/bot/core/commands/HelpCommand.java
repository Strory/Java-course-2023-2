package edu.java.bot.core.commands;

import edu.java.bot.core.handlers.HelpHandler;

public class HelpCommand implements Command {
    private Command nextCommand;
    private final String keyword = "/help";


    public HelpCommand(Command nextCommand) {
        this.nextCommand = nextCommand;
    }

    @Override
    public String getAnswer(String text) {
        if (text.startsWith(keyword)) {
            return HelpHandler.getAnswer();
        } else {
            if (nextCommand.equals(null)) {
                return "bad request";
            }
            return nextCommand.getAnswer(text);
        }
    }
}

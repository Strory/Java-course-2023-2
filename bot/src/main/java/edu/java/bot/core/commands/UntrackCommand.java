package edu.java.bot.core.commands;

public class UntrackCommand implements Command {
    private Command nextCommand;
    private final String keyword = "/untrack";


    public UntrackCommand(Command nextCommand) {
        this.nextCommand = nextCommand;
    }

    @Override
    public String getAnswer(String text) {
        if (text.startsWith(keyword)) {
            return "untrack command"; // пока заглушка
        } else {
            if (nextCommand.equals(null)) {
                return "bad request";
            }
            return nextCommand.getAnswer(text);
        }
    }
}

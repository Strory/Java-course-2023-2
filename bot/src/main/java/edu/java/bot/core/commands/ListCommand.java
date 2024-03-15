package edu.java.bot.core.commands;

public class ListCommand implements Command {
    private Command nextCommand;
    private final String keyword = "/list";

    public ListCommand(Command nextCommand) {
        this.nextCommand = nextCommand;
    }

    @Override
    public String getAnswer(String text) {
        if (text.startsWith(keyword)) {
            return "list command"; // пока заглушка
        } else {
            if (nextCommand.equals(null)) {
                return "bad request";
            }
            return nextCommand.getAnswer(text);
        }
    }
}

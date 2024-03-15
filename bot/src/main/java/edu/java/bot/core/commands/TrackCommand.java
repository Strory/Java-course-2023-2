package edu.java.bot.core.commands;

public class TrackCommand implements Command {
    private Command nextCommand;
    private final String keyword = "/track";


    public TrackCommand(Command nextCommand) {
        this.nextCommand = nextCommand;
    }

    @Override
    public String getAnswer(String text) {
        if (text.startsWith(keyword)) {
            return "track command"; // пока заглушка
        } else {
            if (nextCommand.equals(null)) {
                return "bad request";
            }
            return nextCommand.getAnswer(text);
        }
    }
}

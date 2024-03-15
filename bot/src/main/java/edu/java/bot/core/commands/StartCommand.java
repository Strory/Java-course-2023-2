package edu.java.bot.core.commands;


public class StartCommand implements Command {

    private Command nextCommand;
    private final String keyword = "/start";


    public StartCommand(Command nextCommand) {
        this.nextCommand = nextCommand;
    }

    @Override
    public String getAnswer(String text) {
        if (text.startsWith(keyword)) {
            return "start command"; // пока заглушка
        } else {
            if (nextCommand.equals(null)) {
                return "bad request";
            }
            return nextCommand.getAnswer(text);
        }
    }
}

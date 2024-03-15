package edu.java.bot.core.commands;

public class DummyCommand implements Command {

    private Command nextCommand;
    private final String keyword = "/start ";


    public DummyCommand(Command nextCommand) {
        this.nextCommand = nextCommand;
    }

    @Override
    public String getAnswer(String text) {
        return "bad request";
    }
}

package edu.java.bot.core.handlers;

public class HelpHandler {

    private HelpHandler() {}

    public static String getAnswer() {
        return "/start registration" + "\n"
            + "/help available commands" + "\n"
            + "/track start tracking" + "\n"
            + "/untrack stop tracking" + "\n"
            + "/list watch list" + "\n";
    }
}

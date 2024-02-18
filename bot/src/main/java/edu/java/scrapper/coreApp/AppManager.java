package edu.java.scrapper.coreApp;

public class AppManager {
    public static void main(String[] args) {
        CommandHandler handler = new MainHandler();
        AppCore core = new AppCore(handler);
        core.startCore();
    }
}

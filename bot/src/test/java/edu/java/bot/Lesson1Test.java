package edu.java.bot;

import static org.assertj.core.api.Assertions.assertThat;

import edu.java.scrapper.coreApp.CommandHandler;
import edu.java.scrapper.coreApp.MainHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Lesson1Test {
    @Test
    @DisplayName("Проверка команды /start")
    void checkCommandStart() {
        //given
        String inputString = "/start";
        CommandHandler commandHandler = new MainHandler();

        //when
        String realAnswer = commandHandler.getAnswer(inputString, "dummy");

        //then
        assertThat(realAnswer).isEqualTo("start command");
    }

    @Test
    @DisplayName("Проверка команды /help")
    void checkCommandHelp() {
        //given
        String inputString = "/help";
        CommandHandler commandHandler = new MainHandler();
        String expectAnswer = "/start registration\n" +
            "/help available commands\n" +
            "/track start tracking\n" +
            "/untrack stop tracking\n" +
            "/list watch list\n";

        //when
        String realAnswer = commandHandler.getAnswer(inputString, "dummy");

        //then
        assertThat(realAnswer).isEqualTo(expectAnswer);
    }

    @Test
    @DisplayName("Проверка команды /track")
    void checkCommandTrack() {
        //given
        String inputString = "/track";
        CommandHandler commandHandler = new MainHandler();
        String expectAnswer = "track command";

        //when
        String realAnswer = commandHandler.getAnswer(inputString, "dummy");

        //then
        assertThat(realAnswer).isEqualTo(expectAnswer);
    }

    @Test
    @DisplayName("Проверка команды /untrack")
    void checkCommandUntrack() {
        //given
        String inputString = "/untrack";
        CommandHandler commandHandler = new MainHandler();
        String expectAnswer = "untrack command";

        //when
        String realAnswer = commandHandler.getAnswer(inputString, "dummy");

        //then
        assertThat(realAnswer).isEqualTo(expectAnswer);
    }

    @Test
    @DisplayName("Проверка команды /list")
    void checkCommandList() {
        //given
        String inputString = "/list";
        CommandHandler commandHandler = new MainHandler();
        String expectAnswer = "list command";

        //when
        String realAnswer = commandHandler.getAnswer(inputString, "dummy");

        //then
        assertThat(realAnswer).isEqualTo(expectAnswer);
    }
}

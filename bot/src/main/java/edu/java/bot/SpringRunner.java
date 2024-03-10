package edu.java.bot;

import edu.java.bot.configuration.ApplicationConfig;
import edu.java.bot.core.AppCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringRunner implements CommandLineRunner {
    private final ApplicationConfig applicationConfig;

    @Autowired
    public SpringRunner(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        AppCore core = new AppCore(applicationConfig.telegramToken());
        core.startCore();
    }
}

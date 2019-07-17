package com.acme.edu.ooad;

public class TestApplication {
    public static void main(String[] args) {
        Logger logger = new Logger(
            new LogSeverityLevelFilter(5),
            new LogConsoleSaver()
        );

        logger.log(new Command("abc", 1));
        logger.log(new Command("abcabcabcabcabc", 6));

        SeverityLevel level = SeverityLevel.DEBUG;
        switch (level) {
            case INFO:
            case DEBUG:
            case ERROR:
        }
        level.getOtherCode();
    }
}

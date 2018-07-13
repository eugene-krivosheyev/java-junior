package com.db.ooad;

public class App {
    public static void main(String[] args) {
        Logger logger = new Logger(
                new ContentSeverityFilter("DEBUG"),
                new ConsoleSaver()
        );

        logger.log("[BLA] some message");
        SeverityLevel.valueOf("ERROR").ordinal()
    }
}

enum SeverityLevel {
    INFO, DEBUG, ERROR
}
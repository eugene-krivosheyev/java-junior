package com.db.ooad;

public class App {
    public static void main(String[] args) {
        Logger logger = new Logger(
                message -> System.out::println,
                new ConsoleSaver()
        );

//        logger.log("[BLA] some message");
//        SeverityLevel.valueOf("ERROR").ordinal()
    }
}

enum SeverityLevel {
    INFO, DEBUG, ERROR
}
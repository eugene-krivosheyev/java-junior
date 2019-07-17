package com.acme.edu.ooad;

public class TestApplication {
    public static void main(String[] args) {
        Logger logger = new Logger(
            new LogMessageLengthFilter(10),
            new LogConsoleSaver()
        );

        logger.log("abc");
        logger.log("abcabcabcabcabc");
    }
}

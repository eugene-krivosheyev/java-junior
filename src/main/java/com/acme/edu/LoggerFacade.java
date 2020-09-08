package com.acme.edu;

public class LoggerFacade {
    static LogMessageController controller = new LogMessageController(new ConsoleLogPrinter());

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void flush() {
        controller.flush();
    }
}

package newlogger.facade;

import newlogger.controller.Controller;
import newlogger.message.ByteMessage;
import newlogger.message.FlushMessage;
import newlogger.message.IntMessage;
import newlogger.message.StringMessage;

public class Logger {
    private static Controller controller = new Controller();

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void flush() {
        controller.log(new FlushMessage());
    }
}

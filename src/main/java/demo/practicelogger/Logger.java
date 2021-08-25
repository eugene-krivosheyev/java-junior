package demo.practicelogger;

public class Logger {
    private static Controller controller;

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }
}

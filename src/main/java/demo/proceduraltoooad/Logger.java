package demo.proceduraltoooad;

public class Logger {
    private static LogService logService = new LogService(
                new ConsolePrinter()
            );

    public static void log(int message) {
        IntMessage intMessage = new IntMessage(message);
        logService.log(intMessage);
    }

}

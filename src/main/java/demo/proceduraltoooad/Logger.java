package demo.proceduraltoooad;

public class Logger {
    private static LogService logService = new LogService(
                new NewConsolePrinter()
            );

    public static void log(int message) {
        // Command (request as object, behavior)
        // VS
        // DTO (data transfer object)
        IntMessage intMessage = new IntMessage(message);
        logService.log(intMessage);
    }

}

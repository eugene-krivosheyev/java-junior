package ooaddemo;

public class SaverFactory {
    public static LoggerSaver create() {
        return new ConsoleLoggerSaver();
    }
}

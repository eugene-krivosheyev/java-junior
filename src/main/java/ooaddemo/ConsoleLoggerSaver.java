package ooaddemo;

public class ConsoleLoggerSaver implements LoggerSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}

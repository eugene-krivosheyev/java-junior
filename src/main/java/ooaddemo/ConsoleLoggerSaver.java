package ooaddemo;

/**
 * IS-A
 */
public class ConsoleLoggerSaver extends LoggerSaver {
    @Override
    public void save(String message) {
        super.save(message);
        System.out.println(message);
    }
}

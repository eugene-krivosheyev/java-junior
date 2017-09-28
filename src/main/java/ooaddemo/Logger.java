package ooaddemo;


public class Logger {
    //Creator
    private LoggerFilter filter = new MessageContentLoggerFilter();
    //Factory Method -> Abstract Factory -> Registry
    private LoggerSaver saver = new SaverFactory().create();

    /**
     * OCP: Open Closed Principle
     * DIP: Dependency Inversion Principle
     */
    public void log(String message) {
        if (!filter.filter(message)) {
            saver.save(message);
        }
    }
}

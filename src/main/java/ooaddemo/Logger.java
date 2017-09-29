package ooaddemo;


final class Logger {
    //Creator
    private final LoggerFilter filter = new MessageContentLoggerFilter();
    private final LoggerSaver saver;

    //Dependency Injection: constructor | setter
    public Logger(final LoggerSaver saver) {
        this.saver = saver;
    }

    /**
     * OCP: Open Closed Principle
     * DIP: Dependency Inversion Principle
     */
    public final void log(String message) {
        if (!filter.filter(message)) {
            saver.save(message);
        }
    }
}
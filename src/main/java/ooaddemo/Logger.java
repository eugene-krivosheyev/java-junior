package ooaddemo;


public class Logger {
    //Creator
    private LoggerFilter filter = new MessageContentLoggerFilter();
    @Autowired
    private LoggerSaver saver;

    //Dependency Injection: constructor | setter
    public Logger(LoggerSaver saver) {
        this.saver = saver;
    }

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

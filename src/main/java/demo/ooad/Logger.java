package demo.ooad;

public class Logger {
    private Saver saver;
    private Filter filter;

    /**
     * Dependency Injection: constructor
     */
    public Logger(Saver saver, Filter filter) {
        this.saver = saver;
        this.filter = filter;
    }

    /**
     * 1 MSLoC
     * @param DTO | Command
     */
    @Deprecated(since = "5.12.9", forRemoval = true)
    public void log(Message message) {
        if (!filter.filter(message)) { // [GoF]: Visitor
            Number number = saver.save(message.getBody());
        }
    }
}

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
    public void log(Message message) {
        if (!filter.filter(message)) { // [GoF]: Visitor
            saver.save(message.getBody());
        }
    }
}

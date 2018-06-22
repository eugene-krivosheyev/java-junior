package demo.ooad;

/**
 * Stateful VS Stateless Design
 */
public class Logger {
    private MessageFilter filter;
    private SaverFactory saverFactory;

    /**
     * DI:
     * - constructor
     * - setter
     * - field
     */
    public Logger(MessageFilter filter, SaverFactory saverFactory) {
        this.filter = filter;
        this.saverFactory = saverFactory;
    }

    public void setFilter(MessageFilter filter) {
        this.filter = filter;
    }

    public void log(String message) {
        if (filter.filter(message)) {
            MessageSaver saver = saverFactory.createSaverWithState();
            saver.setMessage(message);
            saver.save();
        }
    }
}

class App {
    public static void main(String[] args) {
        new Logger(
            new MoonPhaseMessageFilter(),
            new StubSaverFactory()
        );
    }
}

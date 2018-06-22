package demo.ooad;

/**
 * Stateful VS Stateless Design
 */
public class Logger {
    private MessageFilter filter = new MoonPhaseMessageFilter();
    private MessageSaver saver = new ConsoleMessageSaver();

    public void log(String message) {
        if (filter.filter(message)) {
            saver.save(message);
        }
    }
}

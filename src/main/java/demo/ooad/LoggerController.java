package demo.ooad;

import java.util.List;
import java.util.Queue;

public class LoggerController {
    private Saver saver;
    private Filter filter;

    private Message[] array;
    private Message currentState;

    /**
     * Dependency Injection: constructor
     */
    public LoggerController(Saver saver, Filter filter) {
        this.saver = saver;
        this.filter = filter;
    }

    /**
     * 1 MSLoC
     * @param DTO | Command
     */
    @Deprecated(since = "5.12.9", forRemoval = true)
    public void log(Message message) {
        if (!currentState.isSameType(message)) {
            flush();
        } else {
            currentState = currentState.accumulate(message);
        }
    }

    private void flush() {

    }
}

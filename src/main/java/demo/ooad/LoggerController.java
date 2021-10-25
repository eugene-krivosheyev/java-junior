package demo.ooad;

import java.util.List;
import java.util.Queue;

public class LoggerController {
    private Saver saver;
    private Filter filter;
    private Message currentState = new DefaultMessage();

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
        if (!message.isSameType(currentState)) {
            flush();
            currentState = message;
        } else {
            currentState = currentState.accumulate(message);
        }
    }

    private void flush() {
        saver.save(currentState.getBody());
    }
}

class DefaultMessage implements Message {
    @Override
    public String getBody() {
        return null;
    }

    @Override
    public boolean isSameType(Message message) {
        return true;
    }

    @Override
    public Message accumulate(Message message) {
        return message;
    }
}
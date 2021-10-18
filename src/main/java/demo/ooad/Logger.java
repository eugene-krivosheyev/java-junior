package demo.ooad;

public class Logger {
    private Saver saver = new ConsoleSaver();
    private Filter filter = new MessageLengthFilter(); // Rich Domain Model vs *Anemic Domain Model*

    /**
     * 1 MSLoC
     */
    public void log(Message message) {
        if (!filter.filter(message)) {
            saver.save(message.getBody());
        }
    }
}

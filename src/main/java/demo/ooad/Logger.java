package demo.ooad;

public class Logger {
    private Saver saver = new Saver();
    private Filter filter = new Filter(); // Rich Domain Model vs *Anemic Domain Model*

    public void log(Message message) {
        if (!filter.filter(message)) {
            saver.save(message.getBody());
        }
    }
}

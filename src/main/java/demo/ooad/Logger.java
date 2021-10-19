package demo.ooad;

public class Logger {
    private Saver saver = new FileSaver("operations.log");
    private Filter filter = new MessageLengthFilter(100); // Rich Domain Model vs *Anemic Domain Model*

    /**
     * 1 MSLoC
     * @param DTO | Command
     */
    public void log(Message message) {
        if (!filter.filter(message)) {
            saver.save(message.getBody());
            if (saver instanceof FileSaver) {
                final FileSaver fileSaver = (FileSaver) saver;
                fileSaver.close();
            }
        }
    }
}

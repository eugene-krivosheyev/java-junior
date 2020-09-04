package demo.ooad;

public class Logger {
    private ContentLengthLoggerFilter filter = new ContentLengthLoggerFilter(10);
    private FileLoggerSaver saver = new FileLoggerSaver("filename");

    /**
     * @param message
     * @param level
     */
    public void log(LoggerMessage message) {
        if (filter.filter(message)) {
            saver.save(message);
        }
    }
}

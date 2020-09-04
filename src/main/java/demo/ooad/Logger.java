package demo.ooad;

public class Logger {
    private LoggerFilter filter = new ContentLengthLoggerFilter(10);
    private LoggerSaver saver = new FileLoggerSaver("filename");

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

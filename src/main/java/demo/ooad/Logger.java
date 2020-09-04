package demo.ooad;

public class Logger {
    private SeverityLevelLoggerFilter filter = new SeverityLevelLoggerFilter(2);
    private FileLoggerSaver saver = new FileLoggerSaver("filename");

    /**
     * @param message
     * @param level
     */
    public void log(String message, int level) {
        filter.setLevel(level);
        if (filter.filter(message)) {
            saver.save(message);
        }
    }
}

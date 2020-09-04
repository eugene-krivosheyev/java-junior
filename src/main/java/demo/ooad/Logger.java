package demo.ooad;

public class Logger {
    // [GRASP] Creator -> Factory Method
    private LoggerFilter filter = XmlConfigFilterFactory.create();
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

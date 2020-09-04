package demo.ooad;

public class Logger {
    // [GRASP] Creator -> [GoF] Factory Method -> [GoF] Abstract Factory
    private LoggerFilter filter = new XmlConfigFilterFactory().create();
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

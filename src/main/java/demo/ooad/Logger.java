package demo.ooad;

import demo.ooad.filter.LoggerFilter;
import demo.ooad.filter.XmlConfigFilterFactory;
import demo.ooad.saver.LoggerSaver;

public class Logger {
    // [GRASP] Creator -> [GoF] Factory Method -> [GoF] Abstract Factory
    private LoggerFilter filter = new XmlConfigFilterFactory().create();
    private LoggerSaver saver; //Field DI

    // Constructor DI
    public Logger(LoggerSaver saver) {
        this.saver = saver;
    }

    // Setter DI
    public void setSaver(LoggerSaver saver) {
        this.saver = saver;
    }

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

package ooaddemo.controller;


import ooaddemo.filter.FilterFactory;
import ooaddemo.filter.LoggerFilter;
import ooaddemo.filter.MessageContentLengthLoggerFilter;
import ooaddemo.filter.SeverityLevelLoggerFilter;
import ooaddemo.saver.LoggerSaver;

/**
 * System Public API
 */
public class LoggerController {
//    private LoggerSaver saver = new ConsoleLoggerSaver(); //[GRASP]: Creator
//    private LoggerSaver saver = SaverFactory.create(); //[GoF]: Factory Method
//    private LoggerSaver saver = new ???SaverFactory().create(); //[GoF]: Abstract Factory
//    private LoggerSaver saver = Registry.create(); //[PoEAA]: Registry
//    private LoggerSaver saver = Registry.getCurrentConfigurableFactory().create(); //[PoEAA]: Registry

    //Field DI
    private LoggerSaver saver;
    private FilterFactory filterFactory;

    //Constructor DI
    public LoggerController(LoggerSaver saver, FilterFactory filterFactory) {
        this.saver = saver;
        this.filterFactory = filterFactory;
    }

    //Setter DI
    public void setSaver(LoggerSaver saver) {
        this.saver = saver;
    }

    public void log(String message, SeverityLevel level) {
        LoggerFilter filter = filterFactory.create(message, level);
        if (!filter.filter()) {
            saver.save(message);
        }
    }
}

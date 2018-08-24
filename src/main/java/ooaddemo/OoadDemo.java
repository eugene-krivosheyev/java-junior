package ooaddemo;

import ooaddemo.controller.LoggerController;
import ooaddemo.controller.SeverityLevel;
import ooaddemo.filter.FilterFactory;
import ooaddemo.saver.ConsoleLoggerSaver;

public class OoadDemo {
    public static void main(String[] args) {
        //DI Framework: semi-cooked App
        //Spring
        LoggerController logger = new LoggerController(
                new ConsoleLoggerSaver(),
                new FilterFactory(objectsToCreate)
        );

        logger.log("test", SeverityLevel.ERROR);
    }
}

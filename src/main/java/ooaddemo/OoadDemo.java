package ooaddemo;

import ooaddemo.controller.Logger;
import ooaddemo.controller.SeverityLevel;
import ooaddemo.filter.FilterFactory;
import ooaddemo.saver.ConsoleLoggerSaver;

public class OoadDemo {
    public static void main(String[] args) {
        //DI Framework: semi-cooked App
        //Spring
        Logger logger = new Logger(new ConsoleLoggerSaver(), new FilterFactory());
        logger.log("test", SeverityLevel.ERROR);
    }
}

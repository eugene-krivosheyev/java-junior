package ooaddemo;

public class OoadDemo {
    public static void main(String[] args) {
        //DI Framework: semi-cooked App
        //Spring
        Logger logger = new Logger(new ConsoleLoggerSaver(), filterFactory);
        logger.log("test", SeverityLevel.ERROR);
    }
}

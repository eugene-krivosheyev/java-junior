package demo.ooad;

public class Logger {
    //[GRASP] Creator
    private LoggerFilter filter = new MessageLengthLogFilter(10); //Stateful
    //[GoF] Factory Method
    private LogSaver saver //[PoEAA]
            = Registry
                .createLogSaverFactory()
                .createLogSaver();

    //10 MSLoC
    public void log(String message, int severity) {
        if(!filter.filter(message, severity)) {
            saver.save(message);
        }
    }
}

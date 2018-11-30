package demo.ooad;

public class Logger {
    private LoggerFilter filter; //DI
    //[GoF] Factory Method
    private LogSaver saver //[PoEAA]
            = Registry
                .createLogSaverFactory()
                    .createLogSaver();

    //Constructor DI
    public Logger(LoggerFilter filter) {
        this.filter = filter;
    }

    public void setFilter(LoggerFilter filter) {
        this.filter = filter;
    }

    //10 MSLoC
    public void log(Request message, int severity) {
        if(!filter.filter(message, severity)) {
            saver.save(message);
        }
    }
}

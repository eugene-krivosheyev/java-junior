package demo.ooad;

//Service
public class Logger {
    private LoggerFilter filter; //field DI + Reflection

    //[GoF] Factory Method
    private LogSaver saver //[PoEAA]
            = Registry.createLogSaverFactory()
                    .createLogSaver();

    //Constructor DI
    public Logger(LoggerFilter filter) {
        this.filter = filter;
    }

    //Setter DI
    public void setFilter(LoggerFilter filter) {
        this.filter = filter;
    }

    //10 MSLoC
    public void log(Command command, int severity) {
        //not OOAD: "ask"
        if(!filter.filter(command.getMessage, severity)) {
            //OOAD: "tell"
            command.save(saver);
        }
    }
}

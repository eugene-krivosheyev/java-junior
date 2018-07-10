package simpleLogger;

public class SimpleLogger {
    private SimpleFilter simpleFilter;
    private SimpleLoggerSaver simpleLoggerSaver;

    public SimpleLogger(SimpleFilter simpleFilter, SimpleLoggerSaver simpleLoggerSaver){
        this.simpleFilter = simpleFilter;
        this.simpleLoggerSaver = simpleLoggerSaver;
    }

    public void log(String message){
        if (simpleFilter.filter(message)){
            simpleLoggerSaver.save(message);
        }
    }
}

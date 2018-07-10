package simpleLogger;

public class SimpleFilterloggingLevel implements SimpleFilter {
    private final LogLevel logLevel;

    public SimpleFilterloggingLevel(LogLevel logLevel){
        this.logLevel = logLevel;
    }

    @Override
    public boolean filter(String message) {
        switch (logLevel){
            case DEBUG:
                return true;
            case WARN:
                return message.startsWith("[" + LogLevel.WARN.toString() + "]") ||
                        message.startsWith("[" + LogLevel.INFO.toString() + "]");
            case INFO:
                return message.startsWith("[" + LogLevel.INFO.toString() + "]");
            default: return false;
        }
    }
}

package demo;

public class EnumsDemo {
    public static void main(String[] args) {
        LoggerState state = LoggerState.DEFAULT_STATE;

        LoggerState.valueOf("DEFAULT_STATE");
        LoggerState[] values = LoggerState.values();

        LoggerState.DEFAULT_STATE.name();
        LoggerState.DEFAULT_STATE.ordinal();

        LoggerState.DEFAULT_STATE.getProperty();

        final Singleton instance = Singleton.getInstance();
        instance.doSmth();
    }
}

enum LoggerState {
    INT_STATE, STRING_STATE, DEFAULT_STATE
}

final class LoggerStateClass {
    public static LoggerStateClass INT_STATE = new LoggerStateClass("p1");
    public static LoggerStateClass STRING_STATE = new LoggerStateClass("p2");
    public static LoggerStateClass DEFAULT_STATE = new LoggerStateClass("p3")];

    //==============

    private String property;

    private LoggerStateClass(String property) {
        this.property = property;
    }

    public String getProperty() {
        return this.property;
    }
}

class Singleton {
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }

    //---------------------
    private int state;

    private Singleton() {

    }

    public void doSmth() {

    }
}

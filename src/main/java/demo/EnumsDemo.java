package demo;

import static demo.LoggerState.DEFAULT_STATE;
import static demo.LoggerState.valueOf;

public class EnumsDemo {
    public static void main(String[] args) {
        LoggerState state = DEFAULT_STATE;

        valueOf("DEFAULT_STATE");
        LoggerState[] values = LoggerState.values();

        DEFAULT_STATE.name();
        DEFAULT_STATE.ordinal();

//        LoggerState.DEFAULT_STATE.getProperty();

        final Singleton instance = Singleton.getInstance();
        instance.doSmth();
    }
}

enum LoggerState {
    INT_STATE, STRING_STATE, DEFAULT_STATE
}

final class LoggerStateClass {
    public static final LoggerStateClass INT_STATE = new LoggerStateClass("p1");
    public static final LoggerStateClass STRING_STATE = new LoggerStateClass("p2");
    public static final LoggerStateClass DEFAULT_STATE = new LoggerStateClass("p3");

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

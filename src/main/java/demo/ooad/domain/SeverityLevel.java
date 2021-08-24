package demo.ooad.domain;

public enum SeverityLevel {
    //     DEBUG, WARN, ERROR
    // }

    DEBUG("debug"), WARN("warn"), ERROR("error");

    private String message;

    private SeverityLevel(String message) {
        this.message = message;
    }
}

final class SLClass {
    public static final SLClass DEBUG = new SLClass(0);
    public static final SLClass WARN = new SLClass(1);
    public static final SLClass ERROR = new SLClass(2);

    ///

    private int ordinal;

    private SLClass(int ordinal) {
        this.ordinal = ordinal;
    }

    public int getOrdinal() {
        return ordinal;
    }
}
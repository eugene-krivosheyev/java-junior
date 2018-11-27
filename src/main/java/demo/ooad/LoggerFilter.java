package demo.ooad;

//IS-A
public abstract class LoggerFilter {
    public boolean filter(String message, int severity) {
        if (message == null) throw new IllegalArgumentException();
        return true;
    }
}

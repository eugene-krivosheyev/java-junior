package demo.ooad;

public class NullCheckLoggerFilter {
    protected void checkNull(LoggerMessage message) {
        if (message == null) throw new IllegalArgumentException();
    }
}

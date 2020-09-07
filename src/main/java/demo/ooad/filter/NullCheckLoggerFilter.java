package demo.ooad.filter;

import demo.ooad.LoggerMessage;

public class NullCheckLoggerFilter {
    public void checkNull(LoggerMessage message) {
        if (message == null) throw new IllegalArgumentException();
    }
}

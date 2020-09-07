package demo.ooad.filter;

import demo.ooad.LoggerMessage;

public class NullCheckLoggerFilter {
    protected void checkNull(LoggerMessage message) {
        if (message == null) throw new IllegalArgumentException();
    }
}

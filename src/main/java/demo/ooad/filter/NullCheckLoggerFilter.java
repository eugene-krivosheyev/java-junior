package demo.ooad.filter;

import demo.ooad.LoggerMessage;


public class NullCheckLoggerFilter {
    public String checkNull(LoggerMessage message)  {
        if (message == null) throw new IllegalArgumentException();
        return null;
    }
}

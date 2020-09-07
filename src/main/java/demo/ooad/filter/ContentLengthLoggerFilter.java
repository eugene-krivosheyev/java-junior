package demo.ooad.filter;

import demo.ooad.LoggerMessage;

public class ContentLengthLoggerFilter extends NullCheckLoggerFilter implements LoggerFilter {
    private int lengtTreshold;

    public ContentLengthLoggerFilter(int lengtTreshold) {
        this.lengtTreshold = lengtTreshold;
    }

    @Override
    public boolean filter(LoggerMessage message) {
        checkNull(message);

        return message.getMessage().length() < lengtTreshold;
    }

}

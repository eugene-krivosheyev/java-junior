package demo.ooad.filter;

import demo.ooad.LoggerMessage;

public class ContentLengthLoggerFilter extends NullCheckLoggerFilter implements LoggerFilter {
    private int lengtTreshold;

    public ContentLengthLoggerFilter(int lengtTreshold) {
        this.lengtTreshold = lengtTreshold;
    }

    @Override
    public void checkNull(LoggerMessage message) {
        System.out.println("WOW!!!!111");
        super.checkNull(message);
    }

    @Override
    public boolean filter(LoggerMessage message) {
        this.checkNull(message);

        return message.getMessage().length() < lengtTreshold;
    }

}

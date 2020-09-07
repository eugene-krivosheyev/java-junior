package demo.ooad.filter;

import demo.ooad.LoggerMessage;

import java.io.FileInputStream;
import java.io.IOException;

public class ContentLengthLoggerFilter extends NullCheckLoggerFilter implements LoggerFilter {
    private int lengtTreshold;

    public ContentLengthLoggerFilter(int lengtTreshold) {
        this.lengtTreshold = lengtTreshold;
    }

    @Override
    public String checkNull(LoggerMessage message) {
        System.out.println("WOW!!!!111");
        super.checkNull(message);
        return null;
    }

    @Override
    public boolean filter(LoggerMessage message) {
        this.checkNull(message);

        return message.getMessage().length() < lengtTreshold;
    }

}

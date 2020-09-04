package demo.ooad;

public class ContentLengthLoggerFilter implements LoggerFilter {
    private int lengtTreshold;

    public ContentLengthLoggerFilter(int lengtTreshold) {
        this.lengtTreshold = lengtTreshold;
    }

    @Override
    public boolean filter(LoggerMessage message) {
        return message.getMessage().length() < lengtTreshold;
    }
}

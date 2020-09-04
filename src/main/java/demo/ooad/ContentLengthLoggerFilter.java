package demo.ooad;

public class ContentLengthLoggerFilter {
    private int lengtTreshold;

    public ContentLengthLoggerFilter(int lengtTreshold) {
        this.lengtTreshold = lengtTreshold;
    }

    public boolean filter(LoggerMessage message) {
        return message.getMessage().length() < lengtTreshold;
    }
}

package ooaddemo.filter;

public class MessageContentLengthLoggerFilter implements LoggerFilter {
    private String message;

    public MessageContentLengthLoggerFilter(String message) {
        this.message = message;
    }

    @Override
    public boolean filter() {
        return message.length() > 10;
    }
}

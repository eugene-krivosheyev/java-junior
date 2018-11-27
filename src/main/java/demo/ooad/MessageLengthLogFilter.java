package demo.ooad;

public class MessageLengthLogFilter extends LoggerFilter {
    private int maxLength;

    public MessageLengthLogFilter(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean filter(String message, int severity) {
        return super.filter(message, severity) &&
            message.length() < maxLength;
    }
}

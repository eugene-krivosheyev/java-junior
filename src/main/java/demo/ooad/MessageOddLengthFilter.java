package demo.ooad;

public class MessageOddLengthFilter implements MessageFilter {
    @Override
    public boolean filter(String message, SeverityLevel severity) {
        return message.length() % 2 == 0;
    }
}

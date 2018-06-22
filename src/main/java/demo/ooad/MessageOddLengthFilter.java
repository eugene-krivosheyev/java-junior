package demo.ooad;

public class MessageOddLengthFilter implements MessageFilter {
    @Override
    public boolean filter(String message) {
        return message.length() % 2 == 0;
    }
}

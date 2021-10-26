package demo.ooad;

public class MessageLengthFilter implements Filter {
    private final int MESSAGE_MAX_LENGTH;

    public MessageLengthFilter(int messageMaxLength) {
        this.MESSAGE_MAX_LENGTH = messageMaxLength;
    }

    @Override
    public boolean filter(Message message) {
        return message.getBody().length() > MESSAGE_MAX_LENGTH;
    }
}

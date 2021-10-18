package demo.ooad;

public class MessageLengthFilter implements Filter {
    @Override
    public boolean filter(Message message) {
        return message.getBody().length() > 100;
    }
}

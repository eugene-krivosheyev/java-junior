package newlogger.message;

public class StringMessage implements Message {
    private String message;

    public StringMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public Message accumulate(Message message) {
        return null;
    }

    @Override
    public String getDecoratedMessage() {
        return null;
    }
}

package newlogger.message;

public class ByteMessage implements Message {
    private byte message;

    public ByteMessage(byte message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof ByteMessage;
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

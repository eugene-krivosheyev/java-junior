package newlogger.message;

public class IntMessage implements Message {
    private int message;

    public IntMessage(int message) {
        this.message = message;
    }

    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof IntMessage;
    }
}

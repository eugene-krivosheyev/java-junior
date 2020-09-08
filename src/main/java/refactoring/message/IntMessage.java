package refactoring.message;

public class IntMessage implements Message {
    private final int message;

    public IntMessage(int message) {
        this.message = message;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public Message reduce(Message message) {
        return null;
    }
}

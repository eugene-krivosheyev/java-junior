package refactoring.message;

public class StringMessage implements Message {
    private final String message;

    public StringMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean isSameType(Message message) {
        return false;
    }

    @Override
    public Message reduce(Message message) {
        return null;
    }
}

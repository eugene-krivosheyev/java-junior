package refactoring.message;

public class StringMessage implements Message {
    private final String message;

    public StringMessage(String message) {
        this.message = message;
    }
}

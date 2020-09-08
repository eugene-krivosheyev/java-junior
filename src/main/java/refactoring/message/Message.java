package refactoring.message;

public interface Message {
    boolean isSameType(Message message);
    Message reduce(Message message);
}

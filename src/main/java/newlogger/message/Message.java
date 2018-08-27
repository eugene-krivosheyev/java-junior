package newlogger.message;

public interface Message {
    boolean isSameTypeOf(Message message);
    Message accumulate(Message message);
    String getDecoratedMessage();
}

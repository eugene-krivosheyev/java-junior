package demo.ooad;

public interface Message {
    String getBody();
    boolean isSameType(Message message);

    /**
     * !!!
     */
    Message accumulate(Message message);
}

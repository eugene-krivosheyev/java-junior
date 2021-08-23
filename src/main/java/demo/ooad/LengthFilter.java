package demo.ooad;

public class LengthFilter {
    public boolean filter(Message message) {
        return message.getBody().length() > 10;
    }
}

package message;

public class StringMessage extends Message {

    private String body;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public String getBody() {
        return body;
    }
}

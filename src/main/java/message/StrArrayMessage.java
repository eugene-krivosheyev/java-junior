package message;

public class StrArrayMessage extends Message {

    private String[] body;

    public StrArrayMessage(String[] body) {
        this.body = body;
    }

    public String[] getBody() {
        return body;
    }
}

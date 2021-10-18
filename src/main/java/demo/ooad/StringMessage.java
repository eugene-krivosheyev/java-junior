package demo.ooad;

public class StringMessage implements Message {
    private String body;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public String getBody() {
        return "string: " + this.body;
    }
}

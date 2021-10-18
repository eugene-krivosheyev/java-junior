package demo.ooad;

public class Message {
    private String body;

    public Message(String body) {
        this.body = body;
    }

    public String getBody() {
        return "decorated " + this.body;
    }
}

package message;

public class ObjectMessage extends Message {

    private Object body;

    public ObjectMessage(Object body) {
        this.body = body;
    }

    @Override
    public String getBody() {
        return body.toString();
    }
}

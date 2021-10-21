package message;

public class IntArrayMessage extends Message {

    private Integer[] body;

    public IntArrayMessage(Integer[] body) {
        this.body = body;
    }

    @Override
    public Integer[] getBody() {
        return body;
    }
}

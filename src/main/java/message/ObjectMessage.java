package message;

import buffer.Buffer;
import buffer.ObjectBuffer;

public class ObjectMessage implements Message {

    private Object body;

    public ObjectMessage(Object body) {
        this.body = body;
    }

    @Override
    public String getBody() {
        return body.toString();
    }

    @Override
    public Buffer getBuffer() {
        return new ObjectBuffer();
    }
}

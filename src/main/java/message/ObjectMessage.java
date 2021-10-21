package message;

import accumulator.Accumulator;
import accumulator.ObjectAccumulator;

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
    public Accumulator getBuffer() {
        return new ObjectAccumulator();
    }
}

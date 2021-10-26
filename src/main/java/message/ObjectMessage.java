package message;

import accumulator.Accumulator;
import accumulator.ObjectAccumulator;

public class ObjectMessage extends Message {

    private Object body;

    public ObjectMessage(Object body) {
        super(new ObjectAccumulator());
        this.body = body;
    }

    @Override
    public String getBody() {
        return body.toString();
    }
}

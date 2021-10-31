package message;

import accumulator.ObjectAccumulator;

public class ObjectMessage extends AbstractMessage {

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

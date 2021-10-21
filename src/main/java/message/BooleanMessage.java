package message;

import buffer.BoolBuffer;
import buffer.Buffer;

public class BooleanMessage implements Message {

    private Boolean body;

    public BooleanMessage(Boolean body) {
        this.body = body;
    }

    @Override
    public Boolean getBody() {
        return body;
    }

    @Override
    public Buffer getBuffer() {
        return new BoolBuffer();
    }
}

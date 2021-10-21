package message;

import buffer.Buffer;
import buffer.IntArrayBuffer;

public class IntArrayMessage implements Message {

    private Integer[] body;

    public IntArrayMessage(Integer[] body) {
        this.body = body;
    }

    @Override
    public Integer[] getBody() {
        return body;
    }

    @Override
    public Buffer getBuffer() {
        return new IntArrayBuffer();
    }
}

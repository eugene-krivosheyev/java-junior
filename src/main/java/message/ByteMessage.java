package message;

import buffer.Buffer;
import buffer.ByteBuffer;

public class ByteMessage implements Message {

    private Byte body;

    public ByteMessage(Byte body) {
        this.body = body;
    }

    @Override
    public Byte getBody() {
        return body;
    }

    @Override
    public Buffer getBuffer() {
        return new ByteBuffer();
    }
}

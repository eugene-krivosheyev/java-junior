package message;

import buffer.Buffer;
import buffer.IntBuffer;

public class IntMessage implements Message
{
    private final Integer body;

    public IntMessage(Integer integer) {
        body = integer;
    }

    @Override
    public Integer getBody() {
        return body;
    }

    @Override
    public Buffer getBuffer() {
        return new IntBuffer();
    }
}

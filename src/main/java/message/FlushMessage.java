package message;

import buffer.FlushBuffer;

public class FlushMessage implements Message {

    @Override
    public Object getBody() {
        return null;
    }

    @Override
    public FlushBuffer getBuffer() {
        return new FlushBuffer();
    }
}

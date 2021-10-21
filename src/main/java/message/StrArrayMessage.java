package message;

import buffer.Buffer;
import buffer.StrArrayBuffer;

public class StrArrayMessage implements Message {

    private String[] body;

    public StrArrayMessage(String[] body) {
        this.body = body;
    }

    @Override
    public String[] getBody() {
        return body;
    }

    @Override
    public Buffer getBuffer() {
        return new StrArrayBuffer();
    }
}

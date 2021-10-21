package message;

import buffer.Buffer;
import buffer.StrBuffer;

public class StringMessage implements Message {

    private String body;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public Buffer getBuffer() {
        return new StrBuffer();
    }
}

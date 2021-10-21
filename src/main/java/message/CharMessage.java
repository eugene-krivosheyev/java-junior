package message;

import buffer.Buffer;
import buffer.CharBuffer;

public class CharMessage implements Message {

    private Character body;

    public CharMessage(Character body) {
        this.body = body;
    }

    @Override
    public Character getBody() {
        return body;
    }

    @Override
    public Buffer getBuffer() {
        return new CharBuffer();
    }
}

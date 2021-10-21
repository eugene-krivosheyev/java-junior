package message;

import buffer.Buffer;
import buffer.Int2dArrayBuffer;

public class Int2dArrayMessage implements Message {

    private Integer[][] body;

    public Int2dArrayMessage(Integer[][] body) {
        this.body = body;
    }

    @Override
    public Integer[][] getBody() {
        return body;
    }

    @Override
    public Buffer getBuffer() {
        return new Int2dArrayBuffer();
    }
}

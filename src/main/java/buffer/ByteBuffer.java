package buffer;

import message.Message;

public class ByteBuffer extends NumberBuffer {

    private Byte byteValue = 0;

    @Override
    public String getBody() {
        return prefix + byteValue.toString();
    }

    @Override
    public void accumulate(Message byteMessage) {
        this.byteValue = (byte)countSum((int)this.byteValue, (int)byteMessage.getBody(), (int)Byte.MAX_VALUE, (int)Byte.MIN_VALUE);
    }

}

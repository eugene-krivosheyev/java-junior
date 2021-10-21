package buffer;

import message.Message;

import java.util.ArrayList;

public class ByteBuffer extends NumberBuffer {

    private Byte byteValue = 0;

    @Override
    public String getBody() {
        return prefix + byteValue.toString();
    }

    @Override
    public ArrayList<String> getExtraordinaryBody() {
        return lineKeeper.getExtraordinaryBody();
    }

    @Override
    public void accumulate(Message byteMessage) {
        this.byteValue = (byte)countSum((int)this.byteValue, (Byte)byteMessage.getBody(), (int)Byte.MAX_VALUE, (int)Byte.MIN_VALUE);
    }

}

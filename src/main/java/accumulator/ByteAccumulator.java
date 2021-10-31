package accumulator;

import message.Message;

public class ByteAccumulator extends NumberAccumulator {

    private Byte byteValue = 0;

    @Override
    public String getBody() {
        return prefix + byteValue.toString();
    }

    @Override
    public String[] extractUnpromtLines() {
        return unpromtLineKeeper.extract();
    }

    @Override
    public void accumulate(Message byteMessage) {
        this.byteValue = (byte)countSum((int)this.byteValue, (Byte)byteMessage.getBody(), (int)Byte.MAX_VALUE, (int)Byte.MIN_VALUE);
    }

}

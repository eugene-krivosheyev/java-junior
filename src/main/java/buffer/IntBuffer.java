package buffer;

import message.Message;

public class IntBuffer extends NumberBuffer {

    private Integer integer = 0;

    public String getBody() {
        return prefix + integer.toString();
    }

    public void accumulate(Message integer) {
        this.integer = countSum(this.integer, (Integer)integer.getBody(), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

}

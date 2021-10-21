package buffer;

import message.Message;

import java.util.ArrayList;

public class IntBuffer extends NumberBuffer {

    private Integer integer = 0;

    @Override
    public String getBody() {
        return prefix + integer.toString();
    }

    @Override
    public ArrayList<String> getExtraordinaryBody() {
        return lineKeeper.getExtraordinaryBody();
    }

    @Override
    public void accumulate(Message integer) {
        this.integer = countSum(this.integer, (Integer)integer.getBody(), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

}

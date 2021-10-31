package accumulator;

import message.Message;

public class IntAccumulator extends NumberAccumulator {

    private Integer integer = 0;

    @Override
    public String getBody() {
        return prefix + integer.toString();
    }

    @Override
    public String[] extractUnpromtLines() {
        return unpromtLineKeeper.extract();
    }

    @Override
    public void accumulate(Message integer) {
        this.integer = countSum(this.integer, (Integer)integer.getBody(), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

}

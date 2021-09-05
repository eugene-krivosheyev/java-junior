package com.acme.edu.checkers;

import com.acme.edu.Type;
import com.acme.edu.savers.Saver;

public class IntSequenceChecker extends Checker<Integer> {
    private boolean intAccumulateState;
    private int intAccumulateSum;

    public IntSequenceChecker(Saver saver) {
        this.intAccumulateSum = 0;
        this.intAccumulateState = false;
        this.saver = saver;
    }

    public Integer check(Object message) {
        int resultInt = 0;

        if (message instanceof Integer) {
            if (!intAccumulateState) {
                intAccumulateState = true;
            }
            if ((long)intAccumulateSum + (long)((int)message) > (long)Integer.MAX_VALUE) {
                resultInt = Integer.MAX_VALUE;
                intAccumulateSum = (int)((long)intAccumulateSum + (long)((int)message) - (long)Integer.MAX_VALUE);

            } else if ((long)intAccumulateSum + (long)((int)message) < (long)Integer.MIN_VALUE) {
                resultInt = Integer.MIN_VALUE;
                intAccumulateSum = (int)((long)intAccumulateSum + (long)((int)message) - (long)Integer.MIN_VALUE);
            } else {
                intAccumulateSum += (int)message;
                return null;
            }
        } else {
            if (intAccumulateState) {
                resultInt = intAccumulateSum;
                intAccumulateState = false;
                intAccumulateSum = 0;
            } else {
                return null;
            }
        }

        return resultInt;
    }
}

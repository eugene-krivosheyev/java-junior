package com.acme.edu.checkers;

import com.acme.edu.Type;
import com.acme.edu.savers.Saver;

public class IntSequenceChecker extends Checker {
    private boolean intAccumulateState;
    private int intAccumulateSum;

    public IntSequenceChecker(Saver saver) {
        this.intAccumulateSum = 0;
        this.intAccumulateState = false;
        this.saver = saver;
    }

    public void check(Object message){
        if (message instanceof Integer) {
            if (!intAccumulateState) {
                intAccumulateState = true;
            }
            if ((long)intAccumulateSum + (long)((int)message) > (long)Integer.MAX_VALUE) {
                saver.sendToSave(Integer.MAX_VALUE + "");
                intAccumulateSum = (int)((long)intAccumulateSum + (long)((int)message) - (long)Integer.MAX_VALUE);

            }
            else if ((long)intAccumulateSum + (long)((int)message) < (long)Integer.MIN_VALUE) {
                saver.sendToSave(Integer.MIN_VALUE + "");
                intAccumulateSum = (int)((long)intAccumulateSum + (long)((int)message) - (long)Integer.MIN_VALUE);
            }
            else {
                intAccumulateSum += (int)message;
            }
        }
        else {
            if (intAccumulateState) {
                saver.sendToSave(Type.PRIMITIVE.value + intAccumulateSum);
                intAccumulateState = false;
                intAccumulateSum = 0;
            }
        }
    }
}

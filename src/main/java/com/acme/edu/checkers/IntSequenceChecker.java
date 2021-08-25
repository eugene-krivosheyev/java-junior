package com.acme.edu.checkers;

import com.acme.edu.Type;

public class IntSequenceChecker extends Checker {
    private static boolean intAccumulateState;
    private static int intAccumulateSum;

    public IntSequenceChecker(){
        intAccumulateSum = 0;
        intAccumulateState = false;
    }

    public static void check(Object message){
        if (message instanceof Integer) {
            if (!intAccumulateState) {
                intAccumulateState = true;
            }
            if ((long)intAccumulateSum + (long)((int)message) > (long)Integer.MAX_VALUE) {
                System.out.println(Integer.MAX_VALUE);
                intAccumulateSum = (int)((long)intAccumulateSum + (long)((int)message) - (long)Integer.MAX_VALUE);

            }
            else if ((long)intAccumulateSum + (long)((int)message) < (long)Integer.MIN_VALUE) {
                System.out.println(Integer.MIN_VALUE);
                intAccumulateSum = (int)((long)intAccumulateSum + (long)((int)message) - (long)Integer.MIN_VALUE);
            }
            else {
                intAccumulateSum += (int)message;
            }
        }
        else{
            if (intAccumulateState) {
                System.out.println(Type.PRIMITIVE.value + intAccumulateSum);
                intAccumulateState = false;
                intAccumulateSum = 0;
            }
        }
    }
}

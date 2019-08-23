package com.acme.edu;

import com.acme.edu.Logger.LoggingType;

public class LongAccumulator {
    private final static String PREFIX_PRIMITIVE = "primitive: ";

    private LoggingType type;
    long sum;
    long min;
    long max;
    boolean flushed;
    long previousSum;

    public LongAccumulator(LoggingType type, long min, long max) {
        this.type = type;
        this.min = min;
        this.max = max;
        sum = 0;
        previousSum = 0;
        flushed = true;
    }

    public void accumulate(long primitive) {
        flushed = false;
        sum += primitive;
        previousSum = primitive;
    }

    public String flush() {
        if (flushed) return "";

        String res = "";
        if(min < sum && sum < max) {
            res += PREFIX_PRIMITIVE + String.valueOf(sum);
            flushed = true;
        } else {
            res += PREFIX_PRIMITIVE + String.valueOf(previousSum);
            sum -= previousSum;
            previousSum = sum;
        }

        return res;
    }


}

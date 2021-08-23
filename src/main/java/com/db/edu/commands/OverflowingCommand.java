package com.db.edu.commands;

import static com.db.edu.Prefixes.NEGATIVE_OVERFLOW_PREFIX;
import static com.db.edu.Prefixes.POSITIVE_OVERFLOW_PREFIX;
import static com.db.edu.Prefixes.PRIMITIVE_PREFIX;

abstract class OverflowingCommand extends Command {

    protected long accumulator;

    OverflowingCommand(int message) {
        accumulator = message;
    }


    long getAccumulator() {
        return accumulator;
    }

    void checkOverflows(long minValue, long maxValue) {
        if (accumulator > maxValue) {
            builder.append(POSITIVE_OVERFLOW_PREFIX)
                    .append(maxValue)
                    .append(System.lineSeparator());
            accumulator -= maxValue;
        } else if (accumulator < minValue) {
            builder.append(NEGATIVE_OVERFLOW_PREFIX)
                    .append(minValue)
                    .append(System.lineSeparator());
            accumulator -= minValue;
        }
    }

}

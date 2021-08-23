package com.db.edu.commands;

import static com.db.edu.Prefixes.PRIMITIVE_PREFIX;

public class IntCommand extends OverflowingCommand {

    public IntCommand(int message) {
        super(message);
    }

    public IntCommand(int message, int[] messages) {
        super(message);
        for (int msg: messages) {
            accumulateValue(msg);
        }
    }

    public Command accumulate(Command another) {
        if (another instanceof IntCommand) {
            accumulateValue(((IntCommand) another).getAccumulator());
            return this;
        } else {
            finishCommand();
            return another;
        }
    }

    public void finishCommand() {
        builder.append(PRIMITIVE_PREFIX)
                .append(accumulator)
                .append(System.lineSeparator());
    }

    private void accumulateValue(long value) {
        accumulator += value;
        checkOverflows(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}

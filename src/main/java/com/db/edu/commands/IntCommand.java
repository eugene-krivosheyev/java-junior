package com.db.edu.commands;

public class IntCommand extends OverflowingCommand {

    public IntCommand(int message) {
        super(message);
    }

    public Command accumulate(Command another) {
        if (another instanceof IntCommand) {
            accumulator += ((IntCommand) another).getAccumulator();
            checkOverflows(Integer.MIN_VALUE, Integer.MAX_VALUE);
            return this;
        } else {
            finishCommand();
            return another;
        }
    }

}

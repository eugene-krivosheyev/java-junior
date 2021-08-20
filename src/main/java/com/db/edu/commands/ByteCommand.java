package com.db.edu.commands;

public class ByteCommand extends OverflowingCommand {

    public ByteCommand(int message) {
        super(message);
    }

    public Command accumulate(Command another) {
        if (another instanceof ByteCommand) {
            accumulator += ((ByteCommand) another).getAccumulator();
            checkOverflows(Byte.MIN_VALUE, Byte.MAX_VALUE);
            return this;
        } else {
            finishCommand();
            return another;
        }
    }

}

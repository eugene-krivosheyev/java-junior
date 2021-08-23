package com.db.edu.commands;

import static com.db.edu.Prefixes.PRIMITIVE_PREFIX;

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

    public void finishCommand() {
        builder.append(PRIMITIVE_PREFIX)
                .append(accumulator)
                .append(System.lineSeparator());
    }

}

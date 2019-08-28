package com.acme.edu.commands.Integer;

import com.acme.edu.Logger.LoggingType;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.CommandAccumulateInfo;
import com.acme.edu.commands.PrimitiveCommand;

public class IntegerCommand extends PrimitiveCommand {
    private static String PREFIX_PRIMITIVE = "primitive: ";
    private LoggingType type;

    long message;
    private final long MIN_VALUE;
    private final long MAX_VALUE;

    public IntegerCommand(long message, long MIN_VALUE, long MAX_VALUE, LoggingType type) {
        super(type);
        this.MAX_VALUE = MAX_VALUE;
        this.MIN_VALUE = MIN_VALUE;
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }


    public CommandAccumulateInfo accumulate(Command other) {
        if (other == null) return new CommandAccumulateInfo(this, null);
        if (! (other instanceof IntegerCommand)) return new CommandAccumulateInfo(this, other.getDecoratedMessage());
        if (!isTypeEquals(other)) return new CommandAccumulateInfo(this, other.getDecoratedMessage());

        String returnMessage = null;
        long otherMessage = (Long)other.getMessage();
        long sum = (Long)(getMessage()) + otherMessage;
        if(MIN_VALUE > sum /*|| sum > MAX_VALUE*/) {
            //returnMessage = other.getDecoratedMessage();
            throw new IntegerOverflowException("Lower overflow");
        } else if(sum > MAX_VALUE) {
            throw new IntegerOverflowException("Upper overflow");
        } else {
            message += otherMessage;
        }

        return new CommandAccumulateInfo(this, returnMessage);
    }


}


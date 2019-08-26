package com.acme.edu.Commands;

import com.acme.edu.Logger.LoggingType;

public class PrimitiveCommand implements Command{
    private static String PREFIX_PRIMITIVE = "primitive: ";
    private LoggingType type;

    long message;
    private final long MIN_VALUE;
    private final long MAX_VALUE;

    public PrimitiveCommand(long message, long MIN_VALUE, long MAX_VALUE, LoggingType type) {
        this.MAX_VALUE = MAX_VALUE;
        this.MIN_VALUE = MIN_VALUE;
        this.message = message;
        this.type = type;
    }


    public LoggingType getType() {
        return type;
    }

    public Object getMessage() {
        return message;
    }

    @Override
    public String getDecoratedMessage() {
        long tmp_message = message;
        message = 0;
        return PREFIX_PRIMITIVE + tmp_message;
    }

    public boolean isTypeEquals(Command other) {
        return other.getType() == type;
    }

    public CommandAccumulateInfo accumulate(Command other) {
        if (other == null) return new CommandAccumulateInfo(this, null, -1);
        if (! (other instanceof PrimitiveCommand)) return new CommandAccumulateInfo(this, other.getDecoratedMessage(), -1);
        if (!isTypeEquals(other)) return new CommandAccumulateInfo(this, other.getDecoratedMessage(), 0);

        String returnMessage = null;
        long otherMessage = (Long)other.getMessage();
        long sum = (Long)(getMessage()) + otherMessage;
        if(MIN_VALUE > sum || sum > MAX_VALUE) {
            returnMessage = other.getDecoratedMessage();
        } else {
            message += otherMessage;
        }

        return new CommandAccumulateInfo(this, returnMessage, 0);
    }


}

package com.acme.edu.Commands;

import com.acme.edu.Logger.LoggingType;

import java.util.Objects;
import java.util.function.Predicate;

public class IntCommand implements Command {
    private static String PREFIX_PRIMITIVE = "primitive: ";

    private static int message;
    private LoggingType type;


    public IntCommand(int message) {
        this.message = message;
        type = LoggingType.INTARRAY;
    }

    @Override
    public Object getMessage() {
        return message;
    }

    @Override
    public String flush() {
        return null;
    }

    @Override
    public LoggingType getType() {
        return type;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof IntCommand && other.getType() == type;
    }

    @Override
    public CommandAccumulateInfo accumulate(Command other) {
        if (! (other instanceof IntCommand)) return new CommandAccumulateInfo(null, null, -1);
        String returnMessage = "";
        int otherMessage = (Integer)(other.getMessage());
        long sum = (long)message + otherMessage;
        if(Integer.MIN_VALUE > otherMessage && otherMessage > Integer.MAX_VALUE) {
            returnMessage = PREFIX_PRIMITIVE + String.valueOf(message);
            sum = otherMessage;
        }

        return new CommandAccumulateInfo(this, returnMessage, 0);
    }
}

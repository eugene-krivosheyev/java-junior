package com.acme.edu.commands;

import com.acme.edu.Logger.LoggingType;

public interface Command {

    public LoggingType getType();

    public boolean isTypeEquals(Command other);

    /**
     *
     * @param other another command
     * @return wrapper with modified Command and message
     */
    public CommandAccumulateInfo accumulate(Command other);

    public Object getMessage();

    public String getDecoratedMessage();
}


package com.acme.edu.Commands;

import com.acme.edu.Logger.LoggingType;

import java.util.Objects;

public interface Command {

    public LoggingType getType();

    public boolean isTypeEquals(Command other);

    public CommandAccumulateInfo accumulate(Command other);

    public Object getMessage();

    public String getDecoratedMessage();
}


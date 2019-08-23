package com.acme.edu.Commands;

import com.acme.edu.Logger.LoggingType;

import java.util.Objects;

public interface Command {
    public String flush();

    public LoggingType getType();

    public boolean isTypeEquals(Command other);

    public CommandAccumulateInfo accumulate(Command other);

    public Object getMessage();
}


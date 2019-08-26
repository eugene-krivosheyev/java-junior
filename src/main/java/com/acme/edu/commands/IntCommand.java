package com.acme.edu.commands;

import com.acme.edu.Logger.LoggingType;

public class IntCommand extends PrimitiveCommand {

    public IntCommand(int message) {
        super(message, Integer.MIN_VALUE, Integer.MAX_VALUE, LoggingType.INT);
    }
}

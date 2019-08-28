package com.acme.edu.commands.Integer;

import com.acme.edu.Logger.LoggingType;

public class IntCommand extends IntegerCommand {

    public IntCommand(int message) {
        super(message, Integer.MIN_VALUE, Integer.MAX_VALUE, LoggingType.INT);
    }
}

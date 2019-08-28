package com.acme.edu.commands.Integer;

import com.acme.edu.Logger.LoggingType;

public class ByteCommand extends IntegerCommand {
    public ByteCommand(byte message) {
        super(message, Byte.MIN_VALUE, Byte.MAX_VALUE, LoggingType.BYTE);
    }
}

package com.acme.edu.commands;

import com.acme.edu.Logger.LoggingType;

public class ByteCommand extends PrimitiveCommand {
    public ByteCommand(byte message) {
        super(message, Byte.MIN_VALUE, Byte.MAX_VALUE, LoggingType.BYTE);
    }
}

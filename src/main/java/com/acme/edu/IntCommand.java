package com.acme.edu;

public class IntCommand extends PrimitiveCommand {
    private final int message;

    public IntCommand(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }
}

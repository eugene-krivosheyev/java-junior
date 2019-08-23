package com.acme.edu.commands.types.primitive;

import com.acme.edu.commands.Command;

public class IntCommand extends PrimitiveCommand implements Command<Integer> {
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return super.getPrimitivePrefix() + message;
    }

    @Override
    public Integer getMessage() { return message; }
}

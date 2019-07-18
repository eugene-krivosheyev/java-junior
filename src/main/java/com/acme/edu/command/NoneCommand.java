package com.acme.edu.command;

import com.acme.edu.Accumulator;
import com.acme.edu.Type;

public class NoneCommand implements Command {
    @Override
    public boolean accumulate(Command accumulator) {
        return false;
    }

    @Override
    public Type getType() {
        return Type.NONE;
    }

    @Override
    public String messageDecorate() {
        return "None command";
    }
}

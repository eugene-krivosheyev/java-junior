package com.acme.edu.commands;

import com.acme.edu.Constants;
import com.acme.edu.commands.Command;

public abstract class PrimitiveCommand implements Command {
    @Override
    public String getDecorated() {
        return Constants.PRIMITIVE_PREFIX + String.valueOf(getStringMessage());
    }

    abstract public String getStringMessage();
}

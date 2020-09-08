package com.acme.edu.command;

import com.acme.edu.command.Command;

public abstract class PrimitiveCommand implements Command {

    public static String PRIMITIVE_PREFIX = "primitive: ";

    public PrimitiveCommand(Object message) {

    }

    public String decorate() {
        return null;
    }

}

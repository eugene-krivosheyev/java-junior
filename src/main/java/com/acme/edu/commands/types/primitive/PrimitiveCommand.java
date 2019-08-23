package com.acme.edu.commands.types.primitive;

import com.acme.edu.commands.Command;

abstract class PrimitiveCommand  implements Command {
    private static final String PRIMITIVE_PREFIX = "primitive: ";

    String getPrimitivePrefix() {
        return PRIMITIVE_PREFIX;
    }
}

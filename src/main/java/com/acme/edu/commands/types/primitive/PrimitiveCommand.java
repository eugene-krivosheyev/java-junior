package com.acme.edu.commands.types.primitive;


abstract class PrimitiveCommand  {
    private static final String PRIMITIVE_PREFIX = "primitive: ";

    String getPrimitivePrefix() {
        return PRIMITIVE_PREFIX;
    }
}

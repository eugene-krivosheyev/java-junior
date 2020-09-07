package com.acme.edu;

public class IntCommand extends Message {
    public static final String PREFIX_PRIMITIVE = "primitive: ";

    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return PREFIX_PRIMITIVE + message;
    }

/*
    if (type.equals("")) {
        type = "int";
        int_buffer = message;
    } else {
        if ("int".equals(type) && (Integer.MAX_VALUE - int_buffer >= message)) {
            int_buffer += message;
        } else {
            chooseMessageWriter();
            type = "int";
            int_buffer = message;
        }
    }
    */
}

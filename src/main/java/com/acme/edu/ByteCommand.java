package com.acme.edu;

public class ByteCommand extends LoggerMessage implements PrefixSupplier {
    /*if (type.equals("")) {
        type = "byte";
        byte_buffer = message;
    } else {
        if ("byte".equals(type) && (Byte.MAX_VALUE - byte_buffer >= message)) {
            byte_buffer += message;
        } else {
            chooseMessageWriter();
            type = "byte";
            byte_buffer = message;
        }
    }*/
}

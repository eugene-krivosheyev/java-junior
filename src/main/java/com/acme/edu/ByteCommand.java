package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public class ByteCommand extends Command {
    byte message;

    public ByteCommand(byte message) {
        this.message = message;
        accumulator = new ByteAccumulator();
    }

    public byte getMessage() {
        return message;
    }

//    @Override
//    String decorate() {
//        return "primitive: " + message;
//    }

    @Override
    void accumulate() {

    }
}

package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public class IntCommand extends Command {
    int message;

    public IntCommand(int message) {
        this.message = message;
        accumulator = new IntAccumulator();
    }

    public int getMessage() {
        return message;
    }

//    @Override
//    String decorate() {
//        return "primitive: " + message;
//    }

    @Override
    void accumulate() {
        accumulator.add(this);
    }
}

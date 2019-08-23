package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public class StringCommand extends Command {
    String message;
    String accomulatedMessage;
    //Accumulator accumulator = new StringAccumulator();

    public StringCommand(String message) {
        this.message = accomulatedMessage;
        accumulator = new StringAccumulator();
    }

//    @Override
//    String decorate() {
//        return "string: " + message;
//    }


    @Override
    public void accumulate() {
        accumulator.add(this);
    }



}

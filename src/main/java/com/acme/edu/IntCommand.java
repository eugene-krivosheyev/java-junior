package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public class IntCommand implements Command {

    int message;
    private long numberBuffer = 0;

    public IntCommand(int message) {
        this.message = message;
        if (isNumberBufferEmpty) {
            numberBuffer = message;
            isNumberBufferEmpty = false;
        }

    }

    public Integer getMessage() {
        return message;
    }

    @Override
    public String decorate() {
        return "primitive: " + numberBuffer;
    }

    @Override
    public boolean isTypeEqual(Command other) {
        return other instanceof IntCommand;
    }

    @Override
    public void cleanBuffer() {
        isNumberBufferEmpty = true;
    }

    ///////////////


    private boolean isNumberBufferEmpty = true;

    @Override
    public Command accumulate(Command command) {
        if (isNumberBufferEmpty) {
            numberBuffer = 0;
        }
        accumulateNumberConcerningMaxValue(((IntCommand) command).getMessage(), Integer.MAX_VALUE);
        // TODO
        // return new Command();
        return this;
    }

    private void accumulateNumberConcerningMaxValue(int number, int maxValue) {
        //if (numberBuffer + number >= maxValue) {
            //flushIntState();
        //}
        //isNumberBufferNotEmpty = true;
        numberBuffer += number;
    }

//    private void flushIntState() {
//        if (isNumberBufferNotEmpty) {
//            result = (String.valueOf(numberBuffer));
//        }
//        cleanNumberBuffer();
//    }

//    private void cleanNumberBuffer() {
//        numberBuffer = 0;
//        isNumberBufferNotEmpty = false;
//    }
}

package com.acme.edu.command;

public class ArrayCommand implements Command {

    public static String PRIMITIVES_ARRAY_PREFIX = "primitives array: ";

    public int[] message;

    public ArrayCommand(int[] arrayMessage) {
        this.message = arrayMessage;
    }

    @Override
    public String toString() {
        StringBuilder arrayElementsToPrint = new StringBuilder();
        for (int i = 0; i < message.length - 1; i++) {
            arrayElementsToPrint.append(message[i]).append(", ");
        }
        arrayElementsToPrint.append(message[message.length - 1]);

        return PRIMITIVES_ARRAY_PREFIX +  "{" + arrayElementsToPrint + "}";
    }

    @Override
    public String decorate() {
        return  this.toString().replace( PRIMITIVES_ARRAY_PREFIX, "");    //replace("", PRIMITIVES_ARRAY_PREFIX);
    }

    @Override
    public boolean isSameType(Command cmd) {
        return cmd instanceof ArrayCommand;
    }

    @Override
    public Command reduce(Command cmd) {
        return null;
    }

    @Override
    public boolean isOverflow(Command cmd) {
        return false;
    }
}

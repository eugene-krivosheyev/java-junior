package com.acme.edu;

public class ArrayCommand extends LoggerMessage implements PrefixSupplier {
    public static final String PREFIX_ARRAY = "primitives array: ";

    private int[] array;
    private StringBuilder message;

    public ArrayCommand(int[] array) {
        this.array = array;
        message = new StringBuilder("{");
        fillStringWithArray();
        message.append("}");
    }

    private void fillStringWithArray() {
        for (int num : array) {
            message.append(num + ", ");
        }
        message.delete(message.length() - 2, message.length());
    }

    @Override
    public String getMessage() {
        return PREFIX_ARRAY + message;
    }

    public void accumulate(LoggerMessage message) {

    }
}

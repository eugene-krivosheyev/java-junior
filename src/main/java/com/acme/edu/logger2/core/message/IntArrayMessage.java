package com.acme.edu.logger2.core.message;

/**
 * Integer array message realisation.
 */
public class IntArrayMessage extends Message implements MessagePrefix{
    /**
     * Message that contains array of integer values
     * in {value, value, ..., value} format.
     * @param array array of integer values as vararg
     */
    public IntArrayMessage(int ... array) {
        super(PREFIX_ARRAY, null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < array.length - 1; i++) {
            stringBuilder.append(array[i]).append(", ");
        }
        stringBuilder.append(array[array.length - 1]).append("}");
        content = stringBuilder.toString();
    }

    @Override
    protected boolean isSameClass(Message message) {
        return message instanceof IntArrayMessage;
    }
}

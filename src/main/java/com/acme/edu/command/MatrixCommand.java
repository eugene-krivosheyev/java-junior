package com.acme.edu.command;

import com.acme.edu.command.ArrayCommand;
import com.acme.edu.command.Command;

public class MatrixCommand implements Command {

    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static String PRIMITIVES_MATRIX_PREFIX = "primitives matrix: ";

    public int[][] message;

    public MatrixCommand(int[][] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return PRIMITIVES_MATRIX_PREFIX + this.toString();
    }

    @Override
    public boolean isSameType(Command cmd) {
        return cmd instanceof MatrixCommand;
    }

    @Override
    public Command reduce(Command cmd) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder arrayElementsToPrint = new StringBuilder();
        arrayElementsToPrint.append("{").append(LINE_SEPARATOR);
        for (int[] ints : message) {
            arrayElementsToPrint.append((new ArrayCommand(ints)).decorate()).append(LINE_SEPARATOR);
        }
        arrayElementsToPrint.append("}");
        return  PRIMITIVES_MATRIX_PREFIX + arrayElementsToPrint.toString();
    }
}

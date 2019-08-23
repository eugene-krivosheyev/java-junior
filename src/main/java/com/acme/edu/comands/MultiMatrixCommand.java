package com.acme.edu.comands;

import com.acme.edu.Decorate;

import static com.acme.edu.LoggerType.MULTIMATRIX;

public class MultiMatrixCommand implements Command, Decorate {
    private int[][][][] message;

    public MultiMatrixCommand(int[][][][] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        StringBuilder finalMessage = new StringBuilder("{\n");
        for (int[][][] array3d : message) {
            finalMessage.append("{\n");
            for (int[][] array2d : array3d) {
                String decoratedMsg = Decorate.decorateArray2D(array2d)
                        .replace("[", "{\n")
                        .replace("]", "\n}");
                finalMessage.append(decoratedMsg);
            }
            finalMessage.append("\n}\n");
        }
        finalMessage.append("}");
        return MULTIMATRIX.getType() + finalMessage;
    }
}

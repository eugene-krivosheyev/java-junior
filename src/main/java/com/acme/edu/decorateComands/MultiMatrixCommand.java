package com.acme.edu.decorateComands;

import static com.acme.edu.LoggerType.MULTIMATRIX;

public class MultiMatrixCommand implements DecorateCommand {
    private int[][][][] message;

    public MultiMatrixCommand(int[][][][] message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        DecorateArray decorateMultiMatrix = new DecorateMultiMatrix();
        StringBuilder finalMessage = new StringBuilder("{\n");
        for (int[][][] array3d : message) {
            finalMessage.append("{\n");
            for (int[][] array2d : array3d) {
                finalMessage.append(decorateMultiMatrix.decorate(array2d));
            }
            finalMessage.append("\n}\n");
        }
        finalMessage.append("}");
        return MULTIMATRIX.getType() + finalMessage;
    }
}

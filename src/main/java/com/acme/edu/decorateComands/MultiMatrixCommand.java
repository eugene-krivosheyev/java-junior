package com.acme.edu.decorateComands;

import java.util.Arrays;
import java.util.stream.Collectors;

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
            finalMessage
                    .append("{\n")
                    .append(Arrays.stream(array3d)
                    .map(decorateMultiMatrix::decorate)
                    .collect(Collectors.joining("\n")))
                    .append("\n}\n");
        }
        finalMessage.append("}");
        return MULTIMATRIX.getType() + finalMessage;
    }
}

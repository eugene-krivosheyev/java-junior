package commands;

import java.util.Arrays;

public class MultiDimMatrixCommand extends Command {
    private static final String MULTI_DIM_MATRIX_PREFIX = "primitives multimatrix: ";
    private final int[][][][] message;

    public MultiDimMatrixCommand(int[][][][] multiDimMatrix) {
        this.message = multiDimMatrix;
    }

    @Override
    public int[][][][] getMessage() {
        return message;
    }

    // todo make ok
    @Override
    public String getDecorated() {
        String separator = System.lineSeparator();
        StringBuilder result = new StringBuilder(MULTI_DIM_MATRIX_PREFIX + "[" + separator);
        for (int[][][] int3 : ((int[][][][]) message)) {
            result.append("[").append(separator);
            for (int[][] int2 : int3) {
                result.append("[").append(separator);
                for (int[] int1 :int2){
                    result.append(Arrays.toString(int1)).append(separator);
                }
                result.append("]").append(separator);
            }
            result.append("]").append(separator);

        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Command getAccumulated(Command other) {
        return new MultiDimMatrixCommand((int[][][][]) other.getMessage());
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof MultiDimMatrixCommand;
    }
}

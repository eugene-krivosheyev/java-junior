package commands;

import java.util.Arrays;

public class MatrixCommand extends Command {
    private static final String MATRIX_PREFIX = "primitives matrix: ";
    private final int[][] message;

    public MatrixCommand(int[][] matrix) {
        this.message = matrix;
    }

    @Override
    public int[][] getMessage() {
        return message;
    }

    @Override
    public String getDecorated() {
        String separator = System.lineSeparator();
        StringBuilder result = new StringBuilder(MATRIX_PREFIX + "[" + separator);
        for (int[] ints : ((int[][]) message)) {
            result.append(Arrays.toString(ints)).append(separator);
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Command getAccumulated(Command other) {
        return new MatrixCommand((int[][]) other.getMessage());
    }

    @Override
    public Boolean equalsCommand(Command other) {
        return other instanceof MatrixCommand;
    }
}

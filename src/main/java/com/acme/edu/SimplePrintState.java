package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class SimplePrintState implements LoggerState{
    Printer printer = new Printer();

    /**
     * Concatenation of symbols and array elements
     *
     * @param array print array
     */
    public void log(int[] array) {
        int sumElement = 0;
        for (int element : array) {
            sumElement += element;
        }
        if (sumElement != 0){
            printer.print(sumElement + "");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{"+ array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", " + array[i]);
        }
        sb.append("}");
        printer.print(PRIMITIVES_ARRAY + sb.toString());
    }

    /**
     * Concatenation of symbols and array elements
     *
     * @param matrix print the array in the array
     */
    public void log(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("{" + SEP);
        for (int i = 0; i < matrix.length; i++) {
            sb.append("{" + matrix[i][0]);
            for (int j = 1; j < matrix[0].length; j++) {
                sb.append(", " + matrix[i][j]);
            }
            sb.append("}" + SEP);
        }
        sb.append("}");
        printer.print(PRIMITIVES_MATRIX + sb.toString());
    }

    /**
     * Concatenation of symbols and array element
     *
     * @param multiMatrix print miltiMatrix
     */
    public void log(int[][][][] multiMatrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("{" + SEP);
        for (int i = 0; i < 3; i++) {
            sb.append("{" + SEP);
        }
        sb.append(multiMatrix[0][0][0][0] + SEP);
        for (int i = 0; i < 3; i++) {
            sb.append("}" + SEP);
        }
        sb.append("}");
        printer.print(PRIMITIVES_MULTIMATRIX + sb.toString());

    }

    /**
     * Print list of arguments type String
     * @param elements The <code>String...</code> to be printed.
     */
    public void log(String... elements) {
        for (String str : elements) {
            printer.print(str);
        }
    }

    @Override
    public void log(String message) {
        return;
    }

    //Утечка абстракции
    @Override
    public void flush() {
        return;
    }

}

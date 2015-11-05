package com.acme.edu.states;

import com.acme.edu.LogException;
import com.acme.edu.printer.Printable;
import com.acme.edu.printer.PrinterException;
import javafx.fxml.LoadException;

/**
 * Created by Павел on 02.11.2015.
 */
public class UnBufferState implements LoggerState {

    //region fields
    private Printable printer;
    //endregion

    //region constructor

    /**
     * Setting the object Printer
     *
     * @param printer
     */
    public UnBufferState(Printable printer) {
        this.printer = printer;
    }
    //endregion

    //region methods

    /**
     * Concatenation of symbols and array elements
     *
     * @param array print array
     */
    public void log(int[] array) throws LogException {
        int sumElement = 0;
        for (int element : array) {
            sumElement += element;
        }

        try {
            if (sumElement != 0) {
                printer.print(sumElement + "");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("{" + array[0]);
                for (int i = 1; i < array.length; i++) {
                    sb.append(", " + array[i]);
                }
                sb.append("}");
                printer.print(PRIMITIVES_ARRAY + sb.toString());
            }
        } catch (PrinterException e) {
            throw new LogException(e);
        }
    }

    /**
     * Concatenation of symbols and array elements
     *
     * @param matrix print the array in the array
     */
    //отрефакторить!!!
    public void log(int[][] matrix) throws LogException {
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
        try {
            printer.print(PRIMITIVES_MATRIX + sb.toString());
        } catch (PrinterException e) {
            throw new LogException(e);
        }
    }

    /**
     * Concatenation of symbols and array element
     *
     * @param multiMatrix print miltiMatrix
     */
    public void log(int[][][][] multiMatrix) throws LogException {
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
        try {
            printer.print(PRIMITIVES_MULTIMATRIX + sb.toString());
        } catch (PrinterException e) {
            throw new LogException(e);
        }
    }

    /**
     * Print list of arguments type String
     *
     * @param elements The <code>String...</code> to be printed.
     */
    //отрефакторить!!!
    public void log(String... elements) throws LogException {
        try {
            for (String str : elements) {
                printer.print(str);
            }
        }catch (PrinterException e){
            throw new LogException(e);
        }

    }

    /**
     * Print message
     *
     * @param
     */
    @Override
    public void log(String message) throws LogException {
        try {
            printer.print(message);
        } catch (PrinterException e) {
            throw new LogException(e);
        }
    }

    /**
     * Leak abstractions
     */
    @Override
    public void flush() {
        return;
    }
    //endregion

}

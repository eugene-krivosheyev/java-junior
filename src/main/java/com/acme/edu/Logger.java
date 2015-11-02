package com.acme.edu;



/**
 * Class Log method overload
 * Type conversion
 * @version 1.1 2 Nov 2015
 * @author Pavel Seregin
 */
public class Logger implements LoggerState{

    //region fields

    private static final String CHAR = "char: ";
    private static final String REFERENCE = "reference: ";
    private static final String PRIMITIVE = "primitive: ";
    private static final String PRIMITIVES_ARRAY = "primitives array: ";
    private static final String PRIMITIVES_MATRIX = "primitives matrix: ";
    private static final String PRIMITIVES_MULTIMATRIX = "primitives multimatrix: ";
    private static final String SEP = System.lineSeparator();
    private LoggerStateHolder state = LoggerStateHolder.SIMPLE_PRINT;
    //endregion

    public Logger() {
    }

    /**
     * Print duplicate rows.
     * If no duplicates, prints one line.
     * Considers the sum of consecutive integers,
     * If numbers are not consecutive, print the input value.
     *
     * @param message The <code>primitive: int</code> to be printed.
     */
    public void log(int message) {

        if (state == LoggerStateHolder.SUM_INTEGERS) {
            state.loggerState.log(String.valueOf(message));
        } else if (state == LoggerStateHolder.STRING_REPEAITING){
            state.getLoggerState().flush();
            state = LoggerStateHolder.SUM_INTEGERS;
            state.loggerState.log(String.valueOf(message));
        }else{
            state.getLoggerState().log(String.valueOf(message));
        }
    }

    /**
     * Print the sum of consecutive integers and prefix of the "primitive: "
     * Print string and considers the sum of duplication string and prefix of the "string: "
     * if you enter "null", the method will fail.
     *
     * @param message If the input parameters are duplicated, The <code>string: String (x2)</code> to be printed.
     */
    @Override
    public void log(String message) {
        if (state != LoggerStateHolder.STRING_REPEAITING){
            state.getLoggerState().flush();
            state = LoggerStateHolder.STRING_REPEAITING;
            state.loggerState.log(message);
        }else{
            state.getLoggerState().log(message);
        }
    }

    //для методов ниже рефакторинг пока что не производился

    /**
     * Prints an boolean and prefix of the "primitive: "
     *
     * @param message The <code>primitive: boolean</code> to be printed.
     */
    public void log(boolean message) {
        Printer.print(Logger.PRIMITIVE + message);
    }

    /**
     * Prints an char and prefix of the "char: "
     *
     * @param message The <code>char: char</code> to be printed.
     */
    public void log(char message) {
        Printer.print(Logger.CHAR + message);
    }

    /**
     * Prints an Object and prefix of the "reference: "
     *
     * @param message The <code>reference: Object</code> to be printed.
     */
    public void log(Object message) {
        Printer.print(Logger.REFERENCE + message);
    }

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
            Printer.print(sumElement + "");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{"+ array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", " + array[i]);
        }
        sb.append("}");
        Printer.print(PRIMITIVES_ARRAY + sb.toString());
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
        Printer.print(PRIMITIVES_MATRIX + sb.toString());
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
        Printer.print(PRIMITIVES_MULTIMATRIX + sb.toString());

    }

    /**
     * Print list of arguments type String
     * @param elements The <code>String...</code> to be printed.
     */
    public void log(String... elements) {
        for (String str : elements) {
            Printer.print(str);
        }
    }

    /**
     * Clearing buffers
     */
    @Override
    public void flush() {
        state.getLoggerState().flush();
    }


    enum LoggerStateHolder{
        STRING_REPEAITING(new StringState()), //Подсчет повторяющихся строк
        SUM_INTEGERS(new IntState()),         //Суммирование целых чисел
        SIMPLE_PRINT(new SimplePrintState()); //Простой вывод чисел

        private LoggerState loggerState;

        LoggerStateHolder(SimplePrintState simplePrintState) {
            this.loggerState = simplePrintState;
        }

        LoggerStateHolder(IntState intState) {
            this.loggerState = intState;
        }

        LoggerStateHolder(StringState stringState) {
             this.loggerState = stringState;
        }

        public LoggerState getLoggerState() {
            return loggerState;
        }
    }
}

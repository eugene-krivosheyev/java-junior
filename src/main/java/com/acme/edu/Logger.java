package com.acme.edu;



/**
 * Class Log method overload
 * Type conversion
 * @version 1.1 2 Nov 2015
 * @author Pavel Seregin
 */
public class Logger {

    //region fields

    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";
    private static final String PRIMITIVE = "primitive: ";
    private static final String PRIMITIVES_ARRAY = "primitives array: ";
    private static final String PRIMITIVES_MATRIX = "primitives matrix: ";
    private static final String PRIMITIVES_MULTIMATRIX = "primitives multimatrix: ";
    private static final String SEP = System.lineSeparator();
    private static String buffer;
    private static Enum anEnum;
    private static String previousLine = "";
    private static int sum = -1;
    private static int countDuplicateString = 0;
    private LoggerStateHolder state = LoggerStateHolder.SIMPLE_PRINT;
    //endregion

    public Logger() {
    }

    //

    /**
     * Prints an boolean and prefix of the "primitive: "
     *
     * @param message The <code>primitive: boolean</code> to be printed.
     */
    public static void log(boolean message) {
        print(Logger.PRIMITIVE + message);
    }

    /**
     * Prints an char and prefix of the "char: "
     *
     * @param message The <code>char: char</code> to be printed.
     */
    public static void log(char message) {
        print(Logger.CHAR + message);
    }

    /**
     * Prints an Object and prefix of the "reference: "
     *
     * @param message The <code>reference: Object</code> to be printed.
     */
    public static void log(Object message) {
        print(Logger.REFERENCE + message);
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

        if (state != LoggerStateHolder.SIMPLE_PRINT){
            if (state == LoggerStateHolder.SUM_INTEGERS){
                state.loggerState.log(String.valueOf(message));
            }else {
                state.getLoggerState().flush();
                state = LoggerStateHolder.SUM_INTEGERS;
                state.loggerState.log(String.valueOf(message));
            }
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
    public void log(String message) {
        if (state != LoggerStateHolder.STRING_CONCATE){
            state.getLoggerState().flush();
            state = LoggerStateHolder.STRING_CONCATE;
            state.loggerState.log(message);
        }else{
            state.getLoggerState().log(message);
        }
    }


    /**
     * Concatenation of symbols and array elements
     *
     * @param array print array
     */
    public static void log(int[] array) {
        int sumElement = 0;
        for (int element : array) {
            sumElement += element;
        }
        if (sumElement != 0){
            print(sumElement+"");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{"+ array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", " + array[i]);
        }
        sb.append("}");
        print(PRIMITIVES_ARRAY + sb.toString());
    }

    /**
     * Concatenation of symbols and array elements
     *
     * @param matrix print the array in the array
     */
    public static void log(int[][] matrix) {
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
        print(PRIMITIVES_MATRIX + sb.toString());
    }

    /**
     * Concatenation of symbols and array element
     *
     * @param multiMatrix print miltiMatrix
     */
    public static void log(int[][][][] multiMatrix) {
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
        print(PRIMITIVES_MULTIMATRIX + sb.toString());

    }

    /**
     * Print list of arguments type String
     * @param elements The <code>String...</code> to be printed.
     */
    public static void log(String... elements) {
        for (String str : elements) {
            print(str);
        }
    }

    /**
     * Clearing buffers
     */
    public void flush() {
        state.getLoggerState().flush();
      //  state.getIntState().flush();

        printDuplicateString();
        previousLine = "";
        sum = -1;
        countDuplicateString = 0;
    }

    //region private method
    private static void print(String massege) {
        System.out.println(massege);
    }

    private static void printDuplicateString() {
        if (countDuplicateString > 1) {
            print(String.format("%s%s (x%d)", STRING, previousLine, countDuplicateString));
        }
        if (countDuplicateString == 1) {
            print(STRING + previousLine);
        }
        countDuplicateString = 0;
        previousLine = "";
    }

    private static void printSumInt() {
        if (sum == -1) {
            sum = 0;
        } else if (countDuplicateString == 0) {
            print(PRIMITIVE + sum);
        } else {
            sum = -1;
        }
    }

    private static boolean checkMax(int message) {
        if (message == Integer.MAX_VALUE || message == Byte.MAX_VALUE) {
            print(PRIMITIVE + sum);
            sum = 0;
        }
        if (message + sum < 0) {
            print(PRIMITIVE + sum);
            sum = -1;
            return false;
        }
        return true;
    }
    //endregion

    enum LoggerStateHolder{
        STRING_CONCATE(new StringState()),
        SUM_INTEGERS(new IntState()),
        SIMPLE_PRINT(new SimplePrintState());
        //    BUFFER

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

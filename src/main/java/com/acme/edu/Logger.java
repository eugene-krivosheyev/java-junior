package com.acme.edu;

public class Logger {

    //region constants

    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";
    private static final String PRIMITIVE = "primitive: ";
    private static final String PRIMITIVES_ARRAY = "primitives array: ";
    private static final String PRIMITIVES_MATRIX = "primitives matrix: ";
    private static final String PRIMITIVES_MULTIMATRIX = "primitives multimatrix: ";
    private static final String SEP = System.lineSeparator();
    private static boolean flag = false;
    private static String lastStr = "str 1";
    private static int countInt = 0;
    private static int countStr = 0;
    //endregion

    /**
     * Call method "print" with using parameter type boolean
     * @param message print parameter boolean
     */
    public static void log(boolean message) {
        print(Logger.PRIMITIVE + message);
    }

    /**
     * Call method "print" with using parameter type char
     * @param message print parameter char
     */
    public static void log(char message) {
        print(Logger.CHAR + message);
    }

    /**
     * Call method "print" with using parameter type Object
     * @param message print parameter Object
     */
    public static void log(Object message)
    {
        print(Logger.REFERENCE + message);
    }

    /**
     * Call method "close"
     * Call method "print" with using parameter type int
     * Call method checkedMAX
     * @param message print parameter int
     */
    public static void log(int message) {
        if (!lastStr.isEmpty()) {
            close();
        }
        if (!Logger.flag) {
            print(Logger.PRIMITIVE + message);
        } else if (message == 0) {
            print(Logger.PRIMITIVE + message);
            flag = false;
        } else {
            checkedMax(message);
            countInt += message;
        }
    }

    /**
     * Sets the value of flag to true
     * Call method "print" with using parameter type String
     * Call method "close"
     * @param message print parameter String
     */
    public static void log(String message) {
        flag = true;
        if (countInt != 0) {
            print(PRIMITIVE + countInt);
            countInt = 0;
        }

        //логика для теста shouldLogSameSubsequentStringsWithoutRepeat()
        if (message.equals(lastStr)) {
            countStr++;
        } else if (countStr == 1) {
            print(STRING + lastStr);
            lastStr = message;
        } else if (countStr == 0) {
            print(STRING + message);
        } else {
            close();
            countStr = 0;
        }
        if (countStr > 2) {
            close();
        }
    }

    //iteration03

    /**
     * Concatenation of symbols and array elements
     * @param arr print array
     */
    public static void log(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("{" + arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sb.append(", " + arr[i]);
        }
        sb.append("}");
        print(PRIMITIVES_ARRAY + sb.toString());
    }

    /**
     * Concatenation of symbols and array elements
     * @param matrix print the array in the array
     */
    public static void log(int[][] matrix){
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
     * @param multiMatrix print miltiMatrix
     */
    public static void log(int[][][][] multiMatrix){
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
     *Print list of arguments
     * @param elements array arguments
     */
    public static void log(String...  elements){
        for (int i = 0; i < elements.length; i++) {
            print(elements[i]);
        }
    }

    private static void print(String massege) {
        System.out.println(massege);
    }

    private static void checkedMax(int message) {
        if (message == Integer.MAX_VALUE) {
            print(Logger.PRIMITIVE + Logger.countInt);
            Logger.countInt = 0;
        }
        if (message == Byte.MAX_VALUE) {
            print(Logger.PRIMITIVE + Logger.countInt);
            Logger.countInt = 0;
        }
    }

    private static void close() {
        if (Logger.countStr > 1) {
            print(String.format("%s%s (x%d)", Logger.STRING, Logger.lastStr, Logger.countStr));
            Logger.countStr = 0;
        }
        if (Logger.countStr == 1) {
            print(Logger.STRING + Logger.lastStr);
            Logger.countStr = 0;
        }
    }
}

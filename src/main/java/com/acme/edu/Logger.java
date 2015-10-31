package com.acme.edu;


/**
 * Log method overload
 * Type conversion
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
    private static boolean flag = true;
    private static String lastStr = "str 1";
    private static int countInt = 0;
    private static int countStr = 0;
    //endregion

    private Logger() {
    }

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

        close();

        checkedMax(message);
        countInt += message;
        if (flag) {
            Logger.print(PRIMITIVE + message);
            if (message == 0) {
                countInt = 0;
            }
        }
    }

    /**
     * Sets the value of flag to true
     * Call method "print" with using parameter type String
     * Call method "close"
     * @param message print parameter String
     */
    public static void log(String message) {
        flag = false;

        if (Logger.countInt == 1){
            flag = true;
        } else if (Logger.countInt > 1){
            print(Logger.PRIMITIVE + countInt);
            flag = true;
            countInt = 0;
        }

        if (message.equals(lastStr)) {
            countStr++;
        } else if (countStr == 1) {
            print(STRING + lastStr);
            lastStr = message;
        } else if (countStr == 0) {
            print(STRING + message);
        }
        if (countStr > 2){
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
     *Print list of arguments type String
     * @param elements array arguments
     */
    public static void log(String...  elements){
        for (String str : elements) {
            print(str);
        }
    }

    /**
     *Print of argument type Integer
     * @param elements array arguments
     */
    public static void log(Integer... elements){
        int result = 0;
        for (Integer element :elements) {
            result += element;
        }
        print(""+result);
    }

    private static void print(String massege) {
        System.out.println(massege);
    }

    private static void checkedMax(int count){
        if (count == Integer.MAX_VALUE){
            print(PRIMITIVE + countInt);
            countInt = 0;
        }

        if (count == Byte.MAX_VALUE){
            print(PRIMITIVE + countInt);
            countInt = 0;
        }
    }

    private static void close() {
        if (Logger.countStr > 1) {
            print(String.format("%s%s (x%d)", Logger.STRING, Logger.lastStr, Logger.countStr));
            Logger.countStr = 0;
            flag = true;
        }
        if (Logger.countStr == 1) {
            print(Logger.STRING + Logger.lastStr);
            Logger.countStr = 0;
        }
    }

    public static void main(String[] args) {

        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        System.out.println("--------------------------");
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        System.out.println("---------------------");
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        System.out.println("---------------------");
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);

        System.out.println("-------------------");

        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");

        System.out.println(2147483647 -2147483637);

    }

}

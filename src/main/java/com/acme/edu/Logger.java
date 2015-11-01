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
    private static String previousLine = "";
    private static int sum = -1;
    private static int countDuplicateString = 0;
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
    public static void log(int message)
    {
        if (countDuplicateString >= 1){
            printDuplicateString();
        }

        if (sum == -1){
            print(PRIMITIVE + message);
        }else{
            if (checkMax(message) && message !=0) {
                sum += message;
            }else{
                print(PRIMITIVE + message);
                sum = -1;
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
        if (message == null){
            return;
        }

        //print sum of integer
        printSumInt();


        //print string and count duplication string
        if (message.equals(previousLine)){
            countDuplicateString++;
        }else{
            printDuplicateString();
            previousLine = message;
            countDuplicateString = 1;
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

    /**
     * Clear buffers
     */
    public static void close(){
        printDuplicateString();
        previousLine = "";
        sum = -1;
        countDuplicateString = 0;
    }

    private static void print(String massege) {
        System.out.println(massege);
    }

    private static void printDuplicateString() {
        if (countDuplicateString > 1){
            print(String.format("%s%s (x%d)", STRING, previousLine, countDuplicateString));
        }
        if (countDuplicateString == 1){
            print(STRING + previousLine);
        }
        countDuplicateString = 0;
        previousLine = "";
    }

    private static void printSumInt() {
        if (sum == -1) {
            sum = 0;
        }else if (countDuplicateString == 0 ){
            print(PRIMITIVE + sum);
        }else{
            sum = -1;
        }
    }

    private static boolean checkMax(int message){
        if (message == Integer.MAX_VALUE || message == Byte.MAX_VALUE){
            print(PRIMITIVE + sum);
            sum = 0;
        }
        if (message + sum < 0){
            print(PRIMITIVE + sum);
            sum = -1;
            return false;
        }
        return true;
    }
}

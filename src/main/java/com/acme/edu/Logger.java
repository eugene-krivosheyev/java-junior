package com.acme.edu;



import static java.lang.System.lineSeparator;

public class Logger {
    public static final String sep = lineSeparator();

    private static final String STR_PREFIX = "string: ";
    private static final String PRIM_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String OBJ_PREFIX = "reference: ";
    private static final String ARRAY_PREFIX = "primitives array: ";
    private static final String MATRIX_PREFIX = "primitives matrix: ";

    private static final String INT_TYPE = "int";
    private static final String STRING_TYPE = "string";
    private static final String BYTE_TYPE = "byte";
    private static final String INT_ARRAY_TYPE = "int array";
    private static final String MATRIX_ARRAY_TYPE = "matrix";
    private static final String STR_ARRAY_TYPE = "string array";
    private static String containerType= "";
    private static String stringContainer = "";
    private static int stringsCount = 0;
    private static int intContainer = 0;

    private static int[] intArrayContainer = null;
    private static String[] strArrayContainer = null;
    private static int[][] array2dContainer = null;
    private static int array2dsum = 0;
    private static boolean arraySwitch = false;


    public static void log(int message) {
        typeCheck(INT_TYPE);
        primOps(message, Integer.MAX_VALUE);
    }

    public static void log(byte message) {
        typeCheck(BYTE_TYPE);
        primOps(message,Byte.MAX_VALUE);
    }

    public static void log(char message) {
        getPrintln(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        typeCheck(STRING_TYPE);
        if (stringContainer.isEmpty()) {
            stringContainer = message;
        }else if (!message.equals(stringContainer)){
            flush();
            stringContainer=message;
        }
        stringsCount++;
    }

    public static void log(boolean message) {
        getPrintln(PRIM_PREFIX + message);
    }

    public static void log(Object message) {
        getPrintln(OBJ_PREFIX + message);

    }

    public static void log(int... message) {
        typeCheck(INT_ARRAY_TYPE);
        if (intArrayContainer == null) {
            intArrayContainer = message;
        }
    }

    public static void log(int[][] message) {
        typeCheck(MATRIX_ARRAY_TYPE);
            if (array2dContainer==null) {
                array2dContainer = message;
            }
    }
    public static void log(String... message) {
        typeCheck(STR_ARRAY_TYPE);
        if (strArrayContainer == null) {
            strArrayContainer = message;
        }
    }

    public static void flush(){
        switch (containerType){
            case STRING_TYPE:
                if (stringsCount > 1)
                    getPrintln (STR_PREFIX + stringContainer + " (x" + stringsCount + ")");
                else getPrintln (STR_PREFIX + stringContainer);
                stringContainer="";
                stringsCount=0;
                containerType="";
                break;
            case INT_TYPE:
            case BYTE_TYPE:
                getPrintln(PRIM_PREFIX + intContainer);
                intContainer = 0;
                containerType="";
                break;
            case INT_ARRAY_TYPE:
                if (arraySwitch) {
                    getPrintln(ARRAY_PREFIX + "{" + arrayPrint() + "}");
                }else getPrintln("" + sumArray());
                intArrayContainer =null;
                containerType="";
                break;
            case MATRIX_ARRAY_TYPE:
                System.out.print(MATRIX_PREFIX + array2dsum());
                array2dsum=0;
                containerType="";
                break;
            case STR_ARRAY_TYPE:
                stringArrayOut();
                strArrayContainer=null;
                containerType="";
                break;
        }
    }

    private static void stringArrayOut() {
        if (strArrayContainer!=null) {
            for (int i = 0; i < strArrayContainer.length; i++) {
                getPrintln(strArrayContainer[i]);
            }
        }
    }

    private static int sumArray() {
        int sum = 0;
        if (intArrayContainer !=null) {
            for (int i = 0; i < intArrayContainer.length; i++) sum += intArrayContainer[i];
        }
        return sum;
    }

    public static void asArrayCall(boolean switcher){
        arraySwitch = switcher;
    }
    public static void dropContainerType(){
        containerType="";
    }

    private static String arrayPrint() {
        StringBuilder outage= new StringBuilder();
        for (int i = 0; i < intArrayContainer.length; i++) {
            if (i< intArrayContainer.length-1) outage.append(intArrayContainer[i]).append(", ");
            else outage.append(intArrayContainer[i]);
        }
        return outage.toString();
    }

    private static int array2dsum() {
        for (int[] ints : array2dContainer) {
            for (int j = 0; j < ints.length; j++) {
                array2dsum += ints[j];
            }
        }
        return array2dsum;
    }

    private static void getPrintln(Object message) {
        System.out.println(message);
    }

    private static void typeCheck(String currentType){
        if (containerType.isEmpty()){
            containerType=currentType;
        }else if (!containerType.equals(currentType)){
            flush();
            containerType=currentType;
        }
    }

    private static void primOps(int number, int full){
            int prefull = full - intContainer;
            if (number >= prefull) {
                intContainer = full;
                flush();
                intContainer = number - prefull;
            } else {
                intContainer += number;
            }
        }

}

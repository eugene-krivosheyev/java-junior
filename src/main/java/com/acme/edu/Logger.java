package com.acme.edu;

import com.acme.edu.control.Controller;
import com.acme.edu.control.message.arrays.IntArrayMessage;
import com.acme.edu.control.message.arrays.StringArrayMessage;
import com.acme.edu.control.message.values.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static java.lang.System.lineSeparator;

public class Logger {
    static Controller logger = new Controller();

    public static final String sep = lineSeparator();
    private static boolean isSumming = false;
    private static String collectingType = "";

    private static Integer bufferInteger = 0;
    private static String  bufferString  = "";
    private static Integer stringCounter = 0;

    public static void setSumming(boolean isSum){isSumming = isSum;}

    public static void log(int message) {
        logger.sendMessage(new IntMessage(message,isSumming));
//        prepare(int.class.getTypeName(), String.valueOf(message));
    }

    public static void log(Integer... message) {
        logger.sendMessage(new IntArrayMessage(new ArrayList<Integer>(Arrays.asList(message)),isSumming,1));
//        prepare("int1D",isSumming?Int1DSumMsg(message):Int1DMsg(message));
    }

    public static void log(Integer[]... message) {
//        ArrayList <Object> array
        logger.sendMessage(new IntArrayMessage(new ArrayList<Object>(Arrays.asList(message)),isSumming,1));


//        prepare("int2D",isSumming?Int2DSumMsg(message):Int2DMsg(message));
    }

    public static void log(int[][]... message) {
        prepare("int3D",isSumming?Int3DSumMsg(message):Int3DMsg(message));
    }

    public static void log(int[][][]... message) {
        prepare("int4D",isSumming?Int4DSumMsg(message):Int4DMsg(message));
    }

    public static void log(char message) {
        logger.sendMessage(new CharMessage(message));
//        prepare(char.class.getTypeName(), String.valueOf(message));
    }

    public static void log(byte message) {
        logger.sendMessage(new ByteMessage(message,isSumming));
//        prepare(byte.class.getTypeName(), String.valueOf(message));
    }

    public static void log(String message) {
        logger.sendMessage(new StringMessage(message,isSumming));
//        prepare(String.class.getTypeName(), String.valueOf(message));
    }

    public static void log(String... message) {
        logger.sendMessage(new StringArrayMessage(message,isSumming));
//        prepare("stringArray",stringMsg(isSumming?" ":sep, message));
    }

    public static void log(Boolean message) {
        logger.sendMessage(new BoolMessage(message));
//        prepare(Boolean.class.getTypeName(), String.valueOf(message));
    }

    public static void log(Object message) {
        logger.sendMessage(new ObjectMessage(message));
//        prepare(Object.class.getTypeName(), String.valueOf(message));
    }

    public static void endLogging(){
        logger.endLogging(true);
//        if(String.class.getTypeName() == collectingType){
//            if(stringCounter != 0){
//                print(stringMsg(bufferString,stringCounter));
//            }
//        } else if (int.class.getTypeName() == collectingType){
//            print(bufferInteger.toString());
//        }
    }

    private static String IntSumMsg(Collection message, int sum) {
        for (Object value: message) { sum += Integer.parseInt(value.toString()); }
        return String.valueOf(sum);
    }

    private static String Int1234DSumMsg(Collection message, int dim) {
        int sum = 0;
        switch (dim){
            case 1:{
                sum = Integer.parseInt(IntSumMsg((Collection) message,sum));
            } break;
            default:{
                for (Object value: message) {
                    sum = Integer.parseInt(Int1234DSumMsg((Collection)value,dim-1));
                }
            } break;
        }
        for (Object value: message) { sum = Integer.parseInt(IntSumMsg((Collection) value,sum)); }
        return String.valueOf(sum);
    }

    private static String Int1DSumMsg(int[] message) {
        int sum = 0;
        for (int value: message) { sum += value; }
        return String.valueOf(sum);
    }

    private static String Int1DMsg(int[] message) {
        StringBuilder msg = new StringBuilder("{");
        int len =  message.length;
        for (int i = 0; i<len; ++i) {
            msg.append(message[i]);
            msg.append((i<len-1)?", ":"");
        }
        msg.append("}");
        return  msg.toString();
    }

    private static String Int2DSumMsg(int[][] message) {
        int sum = 0;
        for (int[] value: message) { sum += Integer.parseInt(Int1DSumMsg(value)); }
        return String.valueOf(sum);
    }

    private static String Int2DMsg(int[][] message) {
        StringBuilder msg = new StringBuilder("{"+sep);
        for (int[] intArray : message) {
            msg.append(Int1DMsg(intArray)).append(sep);
        }
        msg.append("}");
        return msg.toString();
    }

    private static String Int3DSumMsg(int[][][] message) {
        int sum = 0;
        for (int[][] value: message) { sum += Integer.parseInt(Int2DSumMsg(value)); }
        return String.valueOf(sum);
    }

    private static String Int3DMsg(int[][]... message) {
        StringBuilder msg = new StringBuilder("{"+sep);
        for (int[][] intArray : message) {
            msg.append(Int2DMsg(intArray)).append(sep);
        }
        msg.append("}");
        return msg.toString();
    }

    private static String Int4DSumMsg(int[][][][] message) {
        int sum = 0;
        for (int[][][] value: message) { sum += Integer.parseInt(Int3DSumMsg(value)); }
        return String.valueOf(sum);
    }

    private static String Int4DMsg(int[][][][] message) {
        StringBuilder msg = new StringBuilder("{"+sep);
        for (int[][][] intCube : message) {
            msg.append(Int3DMsg(intCube)).append(sep);
        }
        msg.append("}");
        return msg.toString();
    }

    private static String stringMsg(String separator, String[] message) {
        StringBuilder sumMsg = new StringBuilder("");
        for (String str: message) {
            sumMsg.append(str).append(separator);
        }
        return sumMsg.toString();
    }

    private static void prepare(String classType, String message) {
        if (!isSumming) {
            print(formatMsg(classType, message));
        } else {
            workWithSumming(classType, message);
        }
    }

    private static String formatMsg(String type, String message) {
        return prefix(type) + message;
    }

    private static String prefix(String type) {
        if (String.class.getTypeName() == type) {
            return "string: ";
        } else if (char.class.getTypeName() == type) {
            return "char: ";
        } else if (Object.class.getTypeName() == type) {
            return "reference: ";
        } else if (Objects.equals("stringArray",type)) {
            return "";
        } else {
            String extra = "";
            if (Objects.equals("int1D",type)) extra = "s array";
            if (Objects.equals("int2D",type)) extra = "s matrix";
            if (Objects.equals("int3D",type)) extra = "s cube";
            if (Objects.equals("int4D",type)) extra = "s multimatrix";
            return String.format("primitive%s: ",extra);
        }
    }

    private static void print(String message){
        System.out.println(message);
    }

    private static String stringMsg(String message, Integer count){
        if (count != 1) {return String.format("%s (x%d)", message,count);}
        return message;
    }

    private static void workWithSumming(String classType, String message) {
        if (Objects.equals(classType,collectingType)){
            workWithSameType(classType, message);
        } else {
            workWithAnotherType(classType, message);
        }
    }

    private static void workWithAnotherType(String classType, String message) {
        endWorkWithPreviosType();
        startWorkWithNewType(classType, message);
    }

    private static void startWorkWithNewType(String classType, String message) {
        collectingType = classType;
        if(String.class.getTypeName() == classType){
            bufferString = message;
            stringCounter = 1;
        } else if (int.class.getTypeName() == classType){
            bufferInteger = Integer.valueOf(message);
        } else {
            print(message);
        }
    }

    private static void endWorkWithPreviosType() {
        if(String.class.getTypeName() == collectingType){
            if(stringCounter != 0){
                print(stringMsg(bufferString,stringCounter));
                stringCounter = 0;
            }
        } else if (int.class.getTypeName() == collectingType){
            print(bufferInteger.toString());
            bufferInteger = 0;
        } else {
            bufferString = "";
            stringCounter = 0;
            bufferInteger = 0;
        }
    }

    private static void workWithSameType(String classType, String message) {
        if(String.class.getTypeName() == classType){
            workWithString(message);
        } else if (int.class.getTypeName() == classType){
            workWithInteger(message);
        } else {
            print(message);
        }
    }

    private static boolean isMAXMIN(int value, int MAX, int MIN){
        return (MAX - bufferInteger < value); //|| (MIN - bufferInteger > value);
    }

    private static void workWithInteger(String message) {
        int MAXValue = Integer.MAX_VALUE;
        int MINValue = Integer.MIN_VALUE;
        if (isMAXMIN(Integer.parseInt(message),MAXValue,MINValue)){
            print(bufferInteger.toString());
            bufferInteger = 0;
        }
        bufferInteger = (bufferInteger + Integer.parseInt(message));
    }

    private static void workWithString(String message) {
        if(Objects.equals(message,bufferString)){
            stringCounter++;
        } else {
            print(stringMsg(bufferString,stringCounter));
            stringCounter = 1;
            bufferString = message;
        }
    }
}

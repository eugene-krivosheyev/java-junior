package com.acme.edu;

import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;

public class LoggerController {
//    private static String primitiveType = "primitive: ";
//    private static String charType = "char: ";
//    private static String stringType = "string: ";
//    private static String referenceType = "reference: ";
//    private static  String arrayType = "primitives array: ";
//    private  static String matrixType = "primitives matrix: ";

    private Saver saver;

    public LoggerController(Saver saver){
        this.saver = saver;
    }

    private void resetBuffer() {
        state = null;
    }

    private static  String getStringFromArray(int [] arr) {
        StringBuilder strForPrint = new StringBuilder("{");
        for (int i = 0; i < arr.length; i++) {
            strForPrint.append(arr[i]);
            if (i < arr.length -1) { strForPrint.append(", ");}
        }
        strForPrint.append("}");
        return strForPrint.toString();
    }
    static int savedInt = 0;
    static String savedString = "";
    static byte savedByte = 0;
    static types last = null;
    static int stringCounter = 0;

    Message state;

    enum types {
        INTEGER ,
        BYTE ,
        STRING
    }

    public void log(Message message){
        if (state == null) {
            state = message;
            return;
        }
        if (!state.isSameType(message)) {
            flush();
            state = message;
            return;
        }
        if (message.isOverFlow(state)) {
            flush();
            state = message;
        }
        else {
            state.updateAccumulator(message);
        }
    }

    public void log(int message) {
        if (last != LoggerController.types.INTEGER && last != null) {
            //printBuffer();
            resetBuffer();
        }
        long safe = savedInt;
        safe += message;
        if(safe > Integer.MAX_VALUE){
            //printBuffer();
            resetBuffer();
            savedInt = message;
        }
        else {
            savedInt += message;
        }
        last = LoggerController.types.INTEGER;
    }

    public void log(byte message) {
        if (last != LoggerController.types.BYTE && last != null) {
            //printBuffer();
            resetBuffer();
        }
        long safe = savedByte;
        safe += message;
        if(safe > Byte.MAX_VALUE){
            //printBuffer();
            resetBuffer();
            savedByte = message;
        }
        else {
            savedByte += message;
        }
        last = LoggerController.types.BYTE;
    }

    public static void log(int[] message) {
        String strForPrint = getStringFromArray(message);
        //printMessage(arrayType + strForPrint);
    }

    public static void log(int[][] message) {
        //System.out.println(matrixType + "{");
        for (int[] arr : message) {
            String strForPrint = getStringFromArray(arr);
            //printMessage(arrayType + strForPrint);
        }
        System.out.println("}");
    }

    public static void log(char message) {
        ///printMessage(charType + message);
    }

    public void log(String message) {
        if ((last != LoggerController.types.STRING && last != null) || (savedString != message && last != null)) {
            //printBuffer();
            resetBuffer();
        }
        savedString = message;
        stringCounter++;
        last = LoggerController.types.STRING;
    }

    public void log(Object message) {
        //printMessage(referenceType + message);
    }

    public void flush() {
        saver.save(state);
        resetBuffer();
    }
}

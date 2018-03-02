package com.acme.edu;

//kdjghdfkgjhdfkgjhdfkgj
/*
gkjfhkgjfhg
лоралопралопр
лпораплорапл
 */


import java.util.Scanner;

import static com.acme.edu.Logger.*;
import static java.lang.Math.sin;

/**
 * Logs messages.
 * @author EK
 * @param
 * @see
 */
public class Logger {
    //region state
    public static String state = null; //Global state
    public static final String MY_CONST = "";
    //endregion
    public static int intCaster;
    public static byte byteCaster;
    public static String stringCaster = "0";
    public static int stringCounter=1;
    public static String preficsPr = new String("primitive: ");
    public static String preficsCh = new String("char: ");
    public static String preficsSt = new String("string: ");
    public static String preficsOb = new String("reference: ");
    public static Prefics prefics;

    static {
        //System.out.println(Logger.state);
        //log(1, 2);
    }

    public static void log(byte message) {
        Message mess = new Message(message, prefics.PRIMITIVE);
        if (message==Byte.MAX_VALUE){
            print(mess.peficsShow(),byteCaster);
            print(mess.peficsShow(),message);
            byteCaster=0;
        }
        byteCaster += message;
        if(message==0){
            print(mess.peficsShow(),message);
        }
    }

    public static void log(int message) {
        Message mess = new Message(message, prefics.PRIMITIVE);
        if (message==Integer.MAX_VALUE){
            print(mess.peficsShow(),intCaster);
            print(mess.peficsShow(),message);
            intCaster=0;
        }
        intCaster += message;
        if(message==0){
            print(mess.peficsShow(),message);
        }
    }

    public static void log(char message) {
        Message mess = new Message(message, prefics.CHAR);
        if(intCaster != 0){
            print(mess.peficsShow(),intCaster);
            intCaster=0;
        }
        if(byteCaster != 0){
            print(mess.peficsShow(), byteCaster);
            byteCaster = 0;
        }
        print(mess.peficsShow(),message);

    }

    public static void log(boolean message) {
        Message mess = new Message(message, prefics.PRIMITIVE);
        if(intCaster != 0){
            print(mess.peficsShow(),intCaster);
            intCaster=0;
        }
        if(byteCaster != 0){
            print(mess.peficsShow(), byteCaster);
            byteCaster = 0;
        }
        print(mess.peficsShow(),message);

    }

    public static void log(String message) {
        if(intCaster != 0){
            print(preficsPr,intCaster);
            intCaster=0;
        }
        if(byteCaster != 0){
            print(preficsPr, byteCaster);
            byteCaster = 0;
        }

        if(stringCaster.equals("0")){
            stringCaster=message;
        } else {
            if(stringCaster.equals(message)){

            }
            String newMessage = stringCaster + stringCounter;
            print(preficsSt,newMessage);
            stringCaster=message;
            stringCounter=1;
        }
        //stringCaster=message;
        print(preficsSt,message);
    }
    public static void log(String... message){
        if(intCaster != 0){
            print(preficsPr,intCaster);
            intCaster=0;
        }
        if(byteCaster != 0){
            print(preficsPr, byteCaster);
            byteCaster = 0;
        }
        for (String mess:message) {
            System.out.println(mess);
        }
    }
    public static void log(int... message){
        System.out.print("primitives array: {");
        for(int i=0; i<message.length; i++){
            if(i==(message.length-1)){
                System.out.println(message[i]+"}");
            } else {
                System.out.print(message[i]+", ");
            }
        }
    }

    public static void log(int[][] message) {
        System.out.println("primitives matrix: {");
        for (int i=0; i<message.length; i++){
            System.out.print("{");
            for (int j=0; j<message[i].length; j++){
                if (j==(message[i].length-1)){
                    System.out.print(message[i][j]);
                    System.out.println("}");
                }else{
                    System.out.print(message[i][j]+", ");
                }
            }
        }
        System.out.println("}");
    }

    public static void log(int[][][][] message) {
        System.out.println("primitives multimatrix: {");
        for (int i=0; i<message.length; i++) {
            System.out.println("{");
            for (int j = 0; j < message[i].length; j++) {
                System.out.println("{");
                for (int k = 0; k < message[i][j].length; k++) {
                    System.out.println("{");
                    for (int l = 0; l < message[i][j][k].length; l++) {
                        if (l == (message[i][j][k].length - 1)) {
                            System.out.println(message[i][j][k][l]);
                            System.out.println("}");
                        } else {
                            System.out.println(message[i][j][k][l] + ", ");
                        }
                    }
                    System.out.println("}");
                }
                System.out.println("}");
            }
            System.out.println("}");
        }
    }

    public static void log(Object message) {
        if(intCaster != 0){
            print(preficsPr,intCaster);
            intCaster=0;
        }
        if(byteCaster != 0){
            print(preficsPr, byteCaster);
            byteCaster = 0;
        }
        print(preficsOb,message);
    }

    public static void print(String prefics, Object message){
        System.out.println(prefics+": "+message);
    }
}

class Demo {
    public static void main(String[] args) {
        //log(1,1);
        log(0);
        System.out.println(MY_CONST);
        log((byte)10);
        log((byte)20);
    }
}

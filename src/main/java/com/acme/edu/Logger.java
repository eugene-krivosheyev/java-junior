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

    static {
        //System.out.println(Logger.state);
        //log(1, 2);
    }

    public static void log(byte message) {
        if (message==Byte.MAX_VALUE){
            print(preficsPr,byteCaster);
            print(preficsPr,message);
            byteCaster=0;
        }
        byteCaster += message;
        if(message==0){
            print(preficsPr,message);
        }
    }

    public static void log(int message) {
        if (message==Integer.MAX_VALUE){
            print(preficsPr,intCaster);
            print(preficsPr,message);
            intCaster=0;
        }
        intCaster += message;
        if(message==0){
            print(preficsPr,message);
        }
    }

    public static void log(char message) {
        if(intCaster != 0){
            print(preficsPr,intCaster);
            intCaster=0;
        }
        if(byteCaster != 0){
            print(preficsPr, byteCaster);
            byteCaster = 0;
        }
        print(preficsCh,message);

    }

    public static void log(boolean message) {
        if(intCaster != 0){
            print(preficsPr,intCaster);
            intCaster=0;
        }
        if(byteCaster != 0){
            print(preficsPr, byteCaster);
            byteCaster = 0;
        }
        print(preficsPr,message);

    }

    public static void log(String message) {
        /*if(intCaster != 0){
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
        }*/
        //stringCaster=message;
        print(preficsSt,message);
    }
    public static void log(int[] message){
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

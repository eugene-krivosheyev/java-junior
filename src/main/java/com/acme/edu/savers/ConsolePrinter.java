package com.acme.edu.savers;

public class ConsolePrinter implements Saver{

    public static final String preficsPr = new String("primitive: ");
    public static final String preficsCh = new String("char: ");
    public static final String preficsSt = new String("string: ");
    public static final String preficsOb = new String("reference: ");

    public static void printToConsole(int message){
        System.out.println(message);
    }
    public static void printToConsole(byte message){
        System.out.println(preficsPr+message);
    }
    public static void printToConsole(char message){
        System.out.println();
    }
    public static void printToConsole(boolean message){

    }
    public static void printToConsole(String message){

    }
    public static void printToConsole(Object message){

    }
}

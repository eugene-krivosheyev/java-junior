package com.acme.edu.savers;

public class ConsolePrinter implements MessageSaver{

    private Object message;
    private String prefics;
    private String postfix;
    private int counter;


    public static final String preficsPr = new String("primitive: ");
    public static final String preficsCh = new String("char: ");
    public static final String preficsSt = new String("string: ");
    public static final String preficsOb = new String("reference: ");

    @Override
    public void output() {

    }
}

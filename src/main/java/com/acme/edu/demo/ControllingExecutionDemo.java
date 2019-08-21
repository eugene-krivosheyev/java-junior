package com.acme.edu.demo;

public class ControllingExecutionDemo {
    public static void main(String[] args) {
        if (args != null) {
            if (args.length >= 3) {
                //main flow
            }
        }

        //============
        //Guard Clauses
        if (args == null) return;
        if (args.length > 3) throw new IllegalArgumentException();

        //gdfgdfgdfgdgf
        //gdfgdfgdfgdgf
        //gdfgdfgdfgdgf
        //gdfgdfgdfgdgf
        //gdfgdfgdfgdgf

        String arg = null;
        switch (arg) {
            case "a" :
                System.out.println("!!!!!");
                break;
            case "b" : switch (arg) {
                case "a" :
                    System.out.println("OMG!!!!");
            }
                System.out.println("?????");
                break;
            default:
                System.out.println("=====");
        }

        outer1: for (int i = 0, b = 1; i < 10_000; i++, b++) {
            outer2: while (true) {
                do {
                    continue outer2;
                } while (false);
            }
        }

        for (String current : args) {
            System.out.println(current);
        }
    }
}

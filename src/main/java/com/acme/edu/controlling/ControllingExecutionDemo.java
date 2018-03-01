package com.acme.edu.controlling;

public class ControllingExecutionDemo {
    public static void мойМетодКакв1С() {

    }

    public static void main(String[] args) {
        if (false) {
            System.out.println(".");
            System.out.println("..");
        } else if (true) {

        } else {

        }

        String str = null;
        switch (str) {
            case "1":
                System.out.println("1");
                break;
            case "2":
                System.out.println("2");
                break;
            case "3":
                System.out.println("3");
                break;
            default:
                System.out.println("....");
        }

        for (int i = 0, j = 0; i != 10; i++, j--) {

        }
//        for(;;) {}

        //WTF
        outer: while (isaBoolean()) {
            inner: do {
//                break outer;
                continue inner;
            } while (true);
        } //finding: bug, issue, WTF

        for (String current : args) {
            System.out.println(current);
        }
    }

    private static boolean isaBoolean() {
        return 1 == 1;
    }

    public void m(int param) {
        //Guard Clauses
        if (param != 0) return; //throw new IllegalArgExc
//        if (state != expected) return;

        //main flow

    }
}

package com.acme.edu;

import java.util.Objects;

public class OperatorsDemo {
    public static void main(String[] args) {
//        String str = null;
//        switch (str) {
//            case "1": {
//                System.out.println("a");
//                break;
//            }
//
//            case "null": System.out.println("b"); break;
//
//            default:
//                System.out.println("any other");
//        }

//        for (int i = 0, i2 = 0; i <= 10; i++, i2--) {
//
//        }

//        while (true) {
//
//        }

//        do {
//
//        } while (true);

        for (String current : args) {
            System.out.println(current);
        }

        label1: do {
            outer: while (???) {
                inner: for (???) {
                    if (????) break inner;
                    if (????) continue outer;
                }
            }
        } while (???);
    }
}

package com.acme.edu.refactoring;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

interface LoggerAccumulator {
    public static final String LOG_LEVEL = "debug";
    public boolean accumulate();

    public static void m() {
        System.out.println("m");
    }

    String getField();

    default void mm() { //Defender methods
        System.out.println("mm");
        accumulate();
        getField();
    }
}


class LADemo implements LoggerAccumulator {
    @Override
    public boolean accumulate() {
        return false;
    }

    @Override
    public String getField() {
        return null;
    }
}

class Demo {
    public static void main(String[] args) {
        System.out.println(LoggerAccumulator.LOG_LEVEL);

        LADemo laDemo = new LADemo();
        laDemo.mm();

        LoggerAccumulator.m();

        List list = new ArrayList();
        list.forEach(System.out::println);
    }
}

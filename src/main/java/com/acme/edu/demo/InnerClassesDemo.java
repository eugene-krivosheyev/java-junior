package com.acme.edu.demo;

import com.acme.edu.Logger;
import com.acme.edu.ooaddemo2.Command;
import com.acme.edu.ooaddemo2.LoggerController;
import com.acme.edu.ooaddemo2.SuperFilter;
import com.acme.edu.ooaddemo2.SuperSaver;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.m(5).toString());

        new LoggerController(
                new SuperFilter() {
                    @Override
                    public boolean isFiltered(Command command) {
                        return false;
                    }
                },

                new SuperSaver() {
                    @Override
                    public void save(String message) {

                    }
                }
        );
    }
}

class Outer {
    private static int staticState = 1;
    private int instanceState = 2;

    public Object m(int param) {
        int localVar = param;

        return new Object() {
            @Override
            public String toString() {
                return staticState + " " + instanceState + " " + localVar;
            }
        };
    }
}
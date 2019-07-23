package com.acme.edu.functional;

import com.acme.edu.ooad.*;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        ChangeAndGetStateable result = outer.m();

        new Logger(new LogSeverityLevelFilter(5),
            new LogSaver() {
                @Override
                public Object save(Command message) throws Exception {
                    return null;
                }
            });
    }
}

/**
 * Top-level
 *
 */
class Outer {
    private static int staticOuterState = 0;
    private int instanceOuterState = 0;

    public ChangeAndGetStateable m() {
        final int localVar = fm();

        ChangeAndGetStateable closure = new ChangeAndGetStateable() {
            @Override
            public int changeAndGetState() {
                System.out.println(localVar);
                return localVar + 1;
            }
        };
        //Registry.register(closure);

        return closure;
    }

    private int fm() {
        return 0;
    }
}

interface ChangeAndGetStateable {
    int changeAndGetState();
}


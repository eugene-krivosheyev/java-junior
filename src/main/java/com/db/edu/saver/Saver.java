package com.db.edu.saver;

import java.io.PrintStream;
import java.util.stream.Stream;

public class Saver {
    private static final PrintStream OUT = System.out;

    public void save(String decoratedMessage){
        OUT.println(decoratedMessage);
    }
}

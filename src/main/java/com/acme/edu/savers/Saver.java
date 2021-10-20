package com.acme.edu.savers;

import java.io.PrintStream;

public abstract class Saver {
    PrintStream output;

    public void print(String message) {
        output.println(message);
    }
}

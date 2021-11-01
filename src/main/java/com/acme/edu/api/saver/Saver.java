package com.acme.edu.api.saver;

import java.io.PrintStream;

public abstract class Saver {
    PrintStream output;

    public void print(String message) {
        output.println(message);
    }
}

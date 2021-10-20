package com.acme.edu.savers;

public class ConsoleSaver extends Saver {
    public ConsoleSaver() {
        super.output = System.out;
    }
}

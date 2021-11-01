package com.acme.edu.api.saver;

public class ConsoleSaver extends Saver {
    public ConsoleSaver() {
        super.output = System.out;
    }
}

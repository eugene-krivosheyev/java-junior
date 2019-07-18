package com.acme.edu.ooad;

public class LogConsoleSaver extends LogDefaultSaver { //IS-A
    @Override
    protected void doStep(Command message) {
        System.out.println(message);
    }
}

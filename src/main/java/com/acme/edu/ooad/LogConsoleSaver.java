package com.acme.edu.ooad;

public class LogConsoleSaver extends LogDefaultSaver { //IS-A
    @Override
    public void doStep(Command message) {
        System.out.println(message);
    }
}

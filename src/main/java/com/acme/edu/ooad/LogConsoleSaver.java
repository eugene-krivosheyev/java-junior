package com.acme.edu.ooad;

public class LogConsoleSaver extends LogDefaultSaver { //IS-A
    @Override
    public void save(Command message) {
        super.save(message);
        System.out.println(message);
    }
}

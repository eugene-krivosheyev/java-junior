package com.acme.edu.demo;

public class AbstractSaver extends Saver {
    public int state;

    @Override //LSP
    public String save(Object message)  {
        super.save("");
        return null;
    }
}

class Saver {
    protected Object save(Object message) {
        System.out.println("saver: ");
        return null;
    }
}
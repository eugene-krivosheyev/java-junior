package com.acme.edu.ooad.interfaces;

import java.io.Serializable;

public interface Saver {
    void save();
}

interface CloseableSaver extends Saver, Serializable {
    void close();
}

class FileCloseableSaver implements CloseableSaver {
    @Override
    public void save() {

    }

    @Override
    public void close() {

    }

    public boolean isWriteable() {
        return false;
    }
}

class ConsoleCloseableSaver implements CloseableSaver {
    @Override
    public void save() {

    }

    @Override
    public void close() {

    }
}

class Demo {
    public static void main(String[] args) {
        CloseableSaver saver = new ConsoleCloseableSaver();
        if (saver instanceof FileCloseableSaver) {
            ((FileCloseableSaver)saver).isWriteable();
        }
    }
}

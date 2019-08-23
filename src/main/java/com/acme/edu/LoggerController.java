package com.acme.edu;

import com.acme.edu.saver.Saver;

public class LoggerController {

    private Saver saver;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public Saver getSaver() {
        return saver;
    }

    public void setSaver(Saver saver) {
        this.saver = saver;
    }
}

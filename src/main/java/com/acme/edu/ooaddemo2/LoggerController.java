package com.acme.edu.ooaddemo2;

public class LoggerController {
    private SuperFilter filter;
    private SuperSaver saver;

    public LoggerController(SuperFilter filter, SuperSaver saver) {
        this.filter = filter;
        this.saver = saver;
    }

    public void log(Command command) {
        if (!filter.isFiltered(command)) {
            saver.save(command.getMessage());
        }
    }
}

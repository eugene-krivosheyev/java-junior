package com.acme.edu;

public class LoggerController {
    private SuperSaver saver;
    private Accumulator accumulator = new Accumulator();

    //    public LoggerController(SuperFilter filter, SuperSaver saver) {
    public LoggerController() {
        this.saver = new ConcoleSaver();
    }

    public void log(Command command) {
        saver.save(command.getDecorated());
    }
}

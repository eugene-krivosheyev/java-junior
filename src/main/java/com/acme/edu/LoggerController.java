package com.acme.edu;

import com.acme.edu.comands.Command;

public class LoggerController {
    private static Printer printer = new Printer();

    public void run(Command command) {
        printer.save(command.decorate());
    }
}
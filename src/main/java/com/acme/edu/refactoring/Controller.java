package com.acme.edu.refactoring;

/**
 * Services, Controllers <- algorithm: Anemic Domain Model
 * Rich Domain Model
 */
public class Controller {
    private final Printerr printerr = new ConsolePrinterr();
    private Command[] buffer = new Command[10_000];

    public void execute(final Command command) {
        if (command.accumulate()) {
            printerr.printt(command.decorate());
        }
    }
}

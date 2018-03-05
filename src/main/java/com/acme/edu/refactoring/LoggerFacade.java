package com.acme.edu.refactoring;

public class LoggerFacade {
    private static Controller controller = new Controller();

    public static void log(int message) {
        Command command = new IntCommand(message);
        controller.execute(command);
    }

    public static void log(String message) {
        StringCommand command = new StringCommand();
        if (command.accumulate(message)) {
            print(command.decorate(message));
        }
    }

    private static void print(String decoratedMessage) {

    }
}

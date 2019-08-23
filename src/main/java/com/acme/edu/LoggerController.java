package com.acme.edu;

/**
 * Created by kate-c on 23/08/2019.
 */
public class LoggerController {
    Saver saver = new ConsoleSaver();

    public void log(Command command) {
        command.accumulate();
        saver.save(command.decorate());
    }
}

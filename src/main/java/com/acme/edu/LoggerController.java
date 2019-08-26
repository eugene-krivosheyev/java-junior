package com.acme.edu;

import com.acme.edu.commands.Command;

/**
 * Created by kate-c on 23/08/2019.
 */
public class LoggerController {
    private Saver saver = new ConsoleSaver();
    private Command state;

    public void flush() {
        if (state == null) return;
        saver.save(state.decorate());
        state = null;
    }

    public void log(Command command) {
        if (state != null && !state.canAccumulateWith(command)) {
            flush();
        }
        accumulate(command);
    }

    private void accumulate(Command cmd) {
        if (state == null) {
            state = cmd;
        } else {
            state = state.accumulate(cmd);
        }
    }
}

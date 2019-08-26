package com.acme.edu;

import com.acme.edu.buffer.Buffer;
import com.acme.edu.commands.Command;
import com.acme.edu.saver.Saver;

class LoggerController {
    private Saver saver;
    private Buffer buffer;

    LoggerController(Saver saver, Buffer buffer) {
        this.saver = saver;
        this.buffer = buffer;
    }

    void handleCommand(Command command) {
        buffer.changeState(command.getState(), () -> buffer.addBuffer(command));
        saver.saveWithPrefix(command);
    }

    void close() { buffer.close(); }
}

package com.acme.edu;

import com.acme.edu.buffer.Buffer;
import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.StringCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.saver.Saver;

class LoggerController {
    private Saver saver;
    private Buffer buffer;

    LoggerController(Saver saver, Buffer buffer) {
        this.saver = saver;
        this.buffer = buffer;
    }

    Saver getSaver() {
        return saver;
    }

    Buffer getBuffer() { return buffer; }

    void addCommand(IntCommand command) {
        buffer.changeState(command.getState(), () -> buffer.addBuffer(command));
        saver.saveWithPrefix(command);
    }


    void addCommand(ByteCommand command) {
        buffer.changeState(command.getState(), () -> buffer.addBuffer(command));
        saver.saveWithPrefix(command);
    }


    void addCommand(StringCommand command) {
        buffer.changeState(command.getState(), () -> buffer.addBuffer(command));
        saver.saveWithPrefix(command);
    }


    void addCommand(Command command) {
        saver.saveWithPrefix(command);
    }


}

package com.acme.edu.buffer;

import com.acme.edu.commands.Command;
import com.acme.edu.saver.ConsoleSaver;

public class Buffer {
    private Command command = null;
    private BufferState state = BufferState.NONE;

    public Buffer() { }

    public void addBuffer(Command newCommand) {
        if (command == null) {
            command = newCommand;
        } else command = command.accumulate(newCommand);
    }

    private void flush(BufferState state) {
        if (command!=null) {
            new ConsoleSaver().saveWithoutPrefix(command);
            command = null;
        }
        this.state = state;
    }

    public void changeState(BufferState newState, AdderBuffer adderBuffer) {
        if(getState() != newState) {
            flush(newState);
        }
        if (adderBuffer!=null) {
            adderBuffer.add();
        }
    }

    private BufferState getState() { return state; }

    public void close() { flush(BufferState.NONE); }
}

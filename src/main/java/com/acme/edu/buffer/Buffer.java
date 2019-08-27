package com.acme.edu.buffer;

import com.acme.edu.commands.Command;
import com.acme.edu.saver.ConsoleSaver;

public class Buffer {
    private Command currentCommand = null;
    private BufferState state = BufferState.NONE;

    public Buffer() { }

    public void addBuffer(Command newCommand) {
        if (currentCommand == null) {
            currentCommand = newCommand;
        } else currentCommand = currentCommand.accumulate(newCommand);
    }

    private void flush(BufferState state) {
        if (currentCommand !=null) {
            new ConsoleSaver().saveWithoutPrefix(currentCommand);
            currentCommand = null;
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

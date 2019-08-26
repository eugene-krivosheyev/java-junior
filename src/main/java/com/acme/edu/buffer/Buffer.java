package com.acme.edu.buffer;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.StringCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.saver.ConsoleSaver;

public class Buffer {

    private Command<String> stringCommand = null;
    private Command<Integer> intCommand = null;
    private Command<Byte> byteCommand = null;

    private BufferState state = BufferState.NONE;

    public Buffer() { }

    public void addBuffer(ByteCommand newCommand) {
        if (byteCommand == null) {
            byteCommand = newCommand;
        } else byteCommand = byteCommand.accumulate(newCommand);

    }

    public void addBuffer(IntCommand newCommand) {
        if (intCommand == null) {
            intCommand = newCommand;
        } else  intCommand = intCommand.accumulate(newCommand);
    }

    public void addBuffer(StringCommand newCommand) {
        if (stringCommand == null) {
            stringCommand = newCommand;
        } else stringCommand = stringCommand.accumulate(newCommand);

    }

    private void flush(BufferState state) {
        printCommands(intCommand, byteCommand, stringCommand);
        clearBuffer(intCommand, byteCommand, stringCommand);
        this.state = state;
    }

    private void printCommands(Command... commands) {
        for (Command command: commands) {
            if (command != null) {
                new ConsoleSaver().saveWithoutPrefix(command);
            }
        }
    }

    private void clearBuffer(Command... commands) {
        for (Command command: commands) {
            command = null;
        }
    }

    private BufferState getState() { return state; }

    public void changeState(BufferState newState, AdderBuffer adderBuffer) {
        if(getState() != newState) {
            flush(newState);
        }
        if (adderBuffer!=null) {
            adderBuffer.add();
        }
    }

    public void close() { flush(BufferState.NONE); }
}

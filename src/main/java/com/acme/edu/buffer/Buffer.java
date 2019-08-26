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
    private Command[] buffers = {byteCommand, intCommand, stringCommand};
    private BufferState state;

    public Buffer() {
        state = BufferState.NONE;
    }

    public void addBuffer(ByteCommand newCommand) {
        state = BufferState.BYTE;
        if (byteCommand == null) {
            byteCommand = newCommand;
        } else byteCommand = byteCommand.accumulate(newCommand);

    }

    public void addBuffer(IntCommand newCommand) {
        state = BufferState.INT;
        if (intCommand == null) {
            intCommand = newCommand;
        } else intCommand = intCommand.accumulate(newCommand);

    }

    public void addBuffer(StringCommand newCommand) {
        state = BufferState.STR;
        if (stringCommand == null) {
            stringCommand = newCommand;
        } else stringCommand = stringCommand.accumulate(newCommand);

    }

    private void flush(BufferState state) {
        printCommands(buffers);
        clearBuffer(buffers);
        this.state = state;
    }

    private void printCommands(Command... commands) {
        for (Command command: commands) {
            if (command != null)
                new ConsoleSaver().saveWithoutPrefix(command);
        }
    }

    private void clearBuffer(Command... commands) {
        for (Command command: commands) { command = null; }
    }

    private BufferState getState() { return state; }

    public void changeState(BufferState state, AdderBuffer adderBuffer) {
        if(getState() != state) {
            flush(state);
        }
        if (adderBuffer!=null)
            adderBuffer.add();
    }
}

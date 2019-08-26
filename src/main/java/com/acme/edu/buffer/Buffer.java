package com.acme.edu.buffer;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.types.StringCommand;
import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.saver.ConsoleSaver;

public class Buffer {

    private Command<String> stringCommand;
    private Command<Integer> intCommand;
    private Command<Byte> byteCommand;
    private Command[] buffers;
    private BufferState state;

    public Buffer() {
        state = BufferState.NONE;
        stringCommand = null;
        intCommand = null;
        byteCommand = null;
        buffers = new Command[]{byteCommand, intCommand, stringCommand};
    }

    public void addBuffer(Command newCommand) {
        switch (newCommand.getState()) {
            case BYTE:
                ByteCommand newByteCommand = new ByteCommand((Byte)newCommand.getMessage());
                if (byteCommand == null) { byteCommand = newByteCommand;
                } else byteCommand = byteCommand.accumulate(newByteCommand);
                break;
            case INT:
                IntCommand newIntCommand = new IntCommand((Integer) newCommand.getMessage());
                if (intCommand == null) { intCommand = newIntCommand;
                } else intCommand = intCommand.accumulate(newIntCommand);
                break;
            case STR:
                StringCommand newStringCommand = new StringCommand((String) newCommand.getMessage());
                if (stringCommand == null) { stringCommand = newStringCommand;
                } else stringCommand = stringCommand.accumulate(newStringCommand);
                break;
             default:
                 break;
        }
        state = newCommand.getState();
    }

    private void flush(BufferState state) {
        printCommands(buffers);
        clearBuffer(buffers);
        this.state = state;
    }

    private void printCommands(Command... commands) {
        for (Command command: commands) {
            if (command != null) new ConsoleSaver().saveWithoutPrefix(command);
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

package com.acme.edu.command;

import com.acme.edu.ControllerState;
import com.acme.edu.MessageTypeName;
import com.acme.edu.saver.Saver;

import static com.acme.edu.MessageTypeName.INT;
import static java.lang.System.lineSeparator;

public class CommandMessageInt implements CommandMessage {
    private int message;
    private int accumulator;

    public CommandMessageInt(int message) {
        this.message = message;
    }

    @Override
    public MessageTypeName getTypeName() {
        return INT;
    }

    public void update(CommandMessageInt command, Saver saver) {
        if (message > 0) {
            if (accumulator > Integer.MAX_VALUE - message) {

            }
        }
    }

    @Override
    public void update(CommandMessage command, Saver saver) {
        if (command instanceof CommandMessageInt){
            update((CommandMessageInt) command, saver);
            return;
        }


    }

    @Override
    public void flush(Saver saver) {
        String decoratorString = "";
        if (saver.isPrimitive()) {
            decoratorString = "primitive: ";
        }
        saver.save(decoratorString + accumulator);
        accumulator = 0;
    }
}

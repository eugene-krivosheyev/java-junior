package com.acme.edu.command;

import com.acme.edu.ControllerState;
import com.acme.edu.MessageTypeName;
import com.acme.edu.saver.Saver;

import static com.acme.edu.MessageTypeName.STRING;

public class CommandMessageString implements CommandMessage {
    private String message;
    private String previousString;
    private int sameStringCount;

    public CommandMessageString(String message) {
        this.message = message;
    }

    @Override
    public MessageTypeName getTypeName() {
        return STRING;
    }

    public void update(CommandMessageString command, Saver saver) {

    }

    @Override
    public void update(CommandMessage command, Saver saver) {
        if (command instanceof CommandMessageString){
            update((CommandMessageString) command, saver);
            return;
        }
    }

    @Override
    public void flush(Saver saver) {

    }
}

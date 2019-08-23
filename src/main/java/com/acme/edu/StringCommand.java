package com.acme.edu;

import java.util.Objects;

/**
 * Created by kate-c on 23/08/2019.
 */
public class StringCommand implements Command {
    String message;
    private String stringBuffer = null;
    private int stringCounter = 0;


    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }


    @Override
    public boolean isTypeEqual(Command other) {
        return (other instanceof StringCommand) && (Objects.equals(this.message, other.getMessage()));
    }

    @Override
    public void cleanBuffer() {
        stringBuffer = null;
    }

    @Override
    public String decorate() {
        return "string: " + message;
    }

    //////////////////////

    @Override
    public Command accumulate(Command command) {
        String message = ((StringCommand)command).getMessage();
        if (stringBuffer == null) {
            initializeStringBuffer(message);
        } else if (stringBuffer.equals(message)) {
            stringCounter++;
        } else {
            flush();
            initializeStringBuffer(message);
        }

        return this;
    }

    private void initializeStringBuffer(String message) {
        stringBuffer = message;
        stringCounter = 1;
    }

    private void flush() {
        if (stringBuffer == null) return;
        if (stringCounter > 1) {
            stringBuffer += " (x" + stringCounter + ")";
        }
        stringBuffer = null;
    }


}

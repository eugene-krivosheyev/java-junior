package com.acme.edu.commands;

import com.acme.edu.exceptions.SaverException;
import com.acme.edu.savers.Saver;

public class StringCommand extends AccumulateCommand {
    private String buffer;
    private Integer counter;

    public StringCommand(String message) {
        this.buffer = message;
        this.counter = 1;
    }

    private StringCommand(String message, int counter) {
        this.buffer = message;
        this.counter = counter;
    }

    @Override
    public String decorate() {
        return "string: " + buffer;
    }

    private String getBuffer() {
        return buffer;
    }

    private int getCounter() {
        return counter;
    }

    @Override
    public AccumulateCommand accumulate(AccumulateCommand prevCommand, Saver saver) throws SaverException {
        if (!buffer.equals(((StringCommand) prevCommand).getBuffer())) {
            prevCommand.flush(saver);
            return this;
        } else {
            return new StringCommand(buffer, ((StringCommand) prevCommand).getCounter() + 1);
        }
    }

    @Override
    public void flush(Saver saver) throws SaverException {
        String message = counter == 1 ? buffer : buffer + " (x" + counter + ")";
        saver.save(new StringCommand(message).decorate());
    }
}

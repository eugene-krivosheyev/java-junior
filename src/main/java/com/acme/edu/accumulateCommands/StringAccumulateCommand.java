package com.acme.edu.accumulateCommands;

import com.acme.edu.Printer;
import com.acme.edu.decorateComands.StringDecorateCommand;

public class StringAccumulateCommand implements AccumulateCommand {
    private String buffer;
    private Integer counter;

    public StringAccumulateCommand(String message) {
        this.buffer = message;
        this.counter = 1;
    }

    private String getBuffer() {
        return buffer;
    }

    private int getCounter() {
        return counter;
    }

    @Override
    public AccumulateCommand accumulate(AccumulateCommand prevCommand, Printer printer) {
        if (!buffer.equals(((StringAccumulateCommand) prevCommand).getBuffer())) {
            prevCommand.flush(printer);
        } else {
            counter = ((StringAccumulateCommand) prevCommand).getCounter() + 1;
        }
        return this;
    }

    @Override
    public void flush(Printer printer) {
        String message = counter == 1 ? buffer : buffer + " (x" + counter + ")";
        counter = 0;
        buffer = "";
        String decorated = new StringDecorateCommand(message).decorate();
        printer.save(decorated);
    }
}

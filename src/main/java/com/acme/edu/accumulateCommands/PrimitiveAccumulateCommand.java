package com.acme.edu.accumulateCommands;

import com.acme.edu.Printer;
import com.acme.edu.decorateComands.PrimitiveDecorateCommand;

public class PrimitiveAccumulateCommand implements AccumulateCommand {
    private Integer buffer;

    public PrimitiveAccumulateCommand(int message) {
        this.buffer = message;
    }

    private int getBuffer() {
        return buffer;
    }

    @Override
    public AccumulateCommand accumulate(AccumulateCommand prevCommand, Printer printer) {
        int prevBuffer = ((PrimitiveAccumulateCommand) prevCommand).getBuffer();
        if ((long) buffer + prevBuffer > Integer.MAX_VALUE) {
            int temp = buffer + prevBuffer - Integer.MAX_VALUE;
            buffer = Integer.MAX_VALUE;
            flush(printer);
            buffer = temp;
        } else if ((long) buffer + prevBuffer < Integer.MIN_VALUE) {
            int temp = buffer + prevBuffer - Integer.MIN_VALUE;
            buffer = Integer.MIN_VALUE;
            flush(printer);
            buffer = temp;
        }else {
            buffer += prevBuffer;
        }
        return this;
    }

    @Override
    public void flush(Printer printer) {
        String message = String.valueOf(buffer);
        buffer = 0;
        String decorated = new PrimitiveDecorateCommand(message).decorate();
        printer.save(decorated);
    }
}

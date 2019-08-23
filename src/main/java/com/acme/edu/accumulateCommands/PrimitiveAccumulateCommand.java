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
            cornerCase(Integer.MAX_VALUE, printer, prevBuffer);
        } else if ((long) buffer + prevBuffer < Integer.MIN_VALUE) {
            cornerCase(Integer.MIN_VALUE, printer, prevBuffer);
        } else {
            buffer += prevBuffer;
        }
        return this;
    }

    private void cornerCase(int cornerValue, Printer printer, int prevBuffer) {
        int temp = buffer + prevBuffer - cornerValue;
        buffer = cornerValue;
        flush(printer);
        buffer = temp;
    }

    @Override
    public void flush(Printer printer) {
        String message = String.valueOf(buffer);
        buffer = 0;
        String decorated = new PrimitiveDecorateCommand(message).decorate();
        printer.save(decorated);
    }
}

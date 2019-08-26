package com.acme.edu.accumulateCommands;

import com.acme.edu.decorateComands.PrimitiveDecorateCommand;
import com.acme.edu.savers.Saver;

public class PrimitiveAccumulateCommand implements AccumulateCommand {
    private Integer buffer;

    public PrimitiveAccumulateCommand(int message) {
        this.buffer = message;
    }

    private int getBuffer() {
        return buffer;
    }

    @Override
    public AccumulateCommand accumulate(AccumulateCommand prevCommand, Saver saver) {
        int prevBuffer = ((PrimitiveAccumulateCommand) prevCommand).getBuffer();
        if ((long) buffer + prevBuffer > Integer.MAX_VALUE) {
            cornerCase(Integer.MAX_VALUE, saver, prevBuffer);
        } else if ((long) buffer + prevBuffer < Integer.MIN_VALUE) {
            cornerCase(Integer.MIN_VALUE, saver, prevBuffer);
        } else {
            buffer += prevBuffer;
        }
        return this;
    }

    private void cornerCase(int cornerValue, Saver saver, int prevBuffer) {
        int temp = buffer + prevBuffer - cornerValue;
        buffer = cornerValue;
        flush(saver);
        buffer = temp;
    }

    @Override
    public void flush(Saver saver) {
        String message = String.valueOf(buffer);
        buffer = 0;
        String decorated = new PrimitiveDecorateCommand(message).decorate();
        saver.save(decorated);
    }
}

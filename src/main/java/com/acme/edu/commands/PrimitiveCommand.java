package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

public class PrimitiveCommand implements AccumulateCommand {
    private String message;
    private Integer buffer;

    public PrimitiveCommand(String message) {
        this.message = message;
    }

    public PrimitiveCommand(int message) {
        this.buffer = message;
    }

    @Override
    public String decorate() {
        return "primitive: " + message;
    }

    private int getBuffer() {
        return buffer;
    }

    @Override
    public AccumulateCommand accumulate(AccumulateCommand prevCommand, Saver saver) {
        int prevBuffer = ((PrimitiveCommand) prevCommand).getBuffer();
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
        String decorated = new PrimitiveCommand(message).decorate();
        saver.save(decorated);
    }
}
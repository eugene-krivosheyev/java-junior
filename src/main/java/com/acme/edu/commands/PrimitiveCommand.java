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
            return cornerCase(Integer.MAX_VALUE, saver, prevBuffer);
        } else if ((long) buffer + prevBuffer < Integer.MIN_VALUE) {
            return cornerCase(Integer.MIN_VALUE, saver, prevBuffer);
        } else {
            return new PrimitiveCommand(buffer + prevBuffer);
        }
    }

    private PrimitiveCommand cornerCase(int cornerValue, Saver saver, int prevBuffer) {
        int temp = buffer + prevBuffer - cornerValue;
        buffer = cornerValue;
        flush(saver);
        return new PrimitiveCommand(temp);
    }

    @Override
    public void flush(Saver saver) {
        String message = String.valueOf(buffer);
        buffer = 0;
        String decorated = new PrimitiveCommand(message).decorate();
        saver.save(decorated);
    }
}
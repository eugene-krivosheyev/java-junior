package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

public class PrimitiveCommand extends AccumulateCommand {
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
        }
        if ((long) buffer + prevBuffer < Integer.MIN_VALUE) {
            return cornerCase(Integer.MIN_VALUE, saver, prevBuffer);
        }
        return new PrimitiveCommand(buffer + prevBuffer);
    }

    private PrimitiveCommand cornerCase(int cornerValue, Saver saver, int prevBuffer) {
        new PrimitiveCommand(cornerValue).flush(saver);
        return new PrimitiveCommand(buffer + prevBuffer - cornerValue);
    }

    @Override
    public void flush(Saver saver) {
        saver.save(new PrimitiveCommand(String.valueOf(buffer)).decorate());
    }
}
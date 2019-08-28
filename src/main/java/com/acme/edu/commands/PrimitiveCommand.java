package com.acme.edu.commands;

import com.acme.edu.exceptions.IntegerMaxOverflowException;
import com.acme.edu.exceptions.IntegerMinOverflowException;
import com.acme.edu.exceptions.SaverException;
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
    public AccumulateCommand accumulate(AccumulateCommand prevCommand, Saver saver) throws SaverException {
        int prevBuffer = ((PrimitiveCommand) prevCommand).getBuffer();
        try {
            checkOverflow(prevBuffer);
        } catch (IntegerMinOverflowException e) {
            return handleOverflow(Integer.MIN_VALUE, saver, prevBuffer);
        } catch (IntegerMaxOverflowException e) {
            return handleOverflow(Integer.MAX_VALUE, saver, prevBuffer);
        }
        return new PrimitiveCommand(buffer + prevBuffer);
    }

    //TODO change public to private later
    public void checkOverflow(int prevBuffer) throws IntegerMaxOverflowException, IntegerMinOverflowException {
        if ((long) buffer + prevBuffer > Integer.MAX_VALUE) {
            throw new IntegerMaxOverflowException("Integer Max overflow");
        }
        if ((long) buffer + prevBuffer < Integer.MIN_VALUE) {
            throw new IntegerMinOverflowException("Integer Min overflow");
        }
    }

    private PrimitiveCommand handleOverflow(int cornerValue, Saver saver, int prevBuffer) throws SaverException {
        new PrimitiveCommand(cornerValue).flush(saver);
        return new PrimitiveCommand(buffer + prevBuffer - cornerValue);
    }

    @Override
    public void flush(Saver saver) throws SaverException {
        saver.save(new PrimitiveCommand(String.valueOf(buffer)).decorate());
    }
}
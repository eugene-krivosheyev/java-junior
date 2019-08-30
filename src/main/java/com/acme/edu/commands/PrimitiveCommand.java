package com.acme.edu.commands;

import com.acme.edu.exceptions.IntegerMaxOverflowException;
import com.acme.edu.exceptions.IntegerMinOverflowException;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.savers.Saver;

public class PrimitiveCommand extends AccumulateCommand {
    private String buffer;

    public PrimitiveCommand(String buffer) {
        this.buffer = buffer;
    }

    @Override
    public String decorate() {
        return "primitive: " + buffer;
    }

    private String getBuffer() {
        return buffer;
    }

    @Override
    public AccumulateCommand accumulate(AccumulateCommand prevCommand, Saver saver) throws SaverException {
        String prevBufferStr = ((PrimitiveCommand) prevCommand).getBuffer();
        int prevBuffer = Integer.parseInt(prevBufferStr);
        try {
            checkOverflow(prevBuffer);
        } catch (IntegerMinOverflowException e) {
            return handleOverflow(Integer.MIN_VALUE, saver, prevBuffer);
        } catch (IntegerMaxOverflowException e) {
            return handleOverflow(Integer.MAX_VALUE, saver, prevBuffer);
        }
        return new PrimitiveCommand(String.valueOf(Integer.parseInt(buffer) + prevBuffer));
    }

    public void checkOverflow(int prevBuffer) throws IntegerMaxOverflowException, IntegerMinOverflowException {
        if ((long) Integer.parseInt(buffer) + prevBuffer > Integer.MAX_VALUE) {
            throw new IntegerMaxOverflowException("Integer Max overflow");
        }
        if ((long) Integer.parseInt(buffer) + prevBuffer < Integer.MIN_VALUE) {
            throw new IntegerMinOverflowException("Integer Min overflow");
        }
    }

    private PrimitiveCommand handleOverflow(int cornerValue, Saver saver, int prevBuffer) throws SaverException {
        new PrimitiveCommand(String.valueOf(cornerValue)).flush(saver);
        return new PrimitiveCommand(String.valueOf(Integer.parseInt(buffer) + prevBuffer - cornerValue));
    }

    @Override
    public void flush(Saver saver) throws SaverException {
        saver.save(new PrimitiveCommand(String.valueOf(buffer)).decorate());
    }
}
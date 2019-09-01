package com.acme.edu.commands.numeric;

import com.acme.edu.commands.AccumulableCommand;
import com.acme.edu.commands.Command;
import com.acme.edu.savers.Saver;

public class ByteCommand extends NumericCommand {
    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public AccumulableCommand accumulate(Command other, Saver saver) {
        if (other instanceof ByteCommand) {
            return sumWithOverflowCheck((ByteCommand) other, saver);
        } else {
            throw new IllegalArgumentException("Can't accumulate ByteCommand with other Command subclass");
        }
    }

    private AccumulableCommand sumWithOverflowCheck(ByteCommand other, Saver saver) {
        long sum = this.message + other.getMessage();

        if (sum > Byte.MAX_VALUE) {
            saver.save(getDecorated());
            return new ByteCommand((byte) other.getMessage());
        } else {
            return new ByteCommand((byte) sum);
        }
    }
}

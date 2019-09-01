package com.acme.edu.commands.numeric;

import com.acme.edu.commands.AccumulableCommand;
import com.acme.edu.commands.Command;
import com.acme.edu.savers.Saver;

public class IntCommand extends NumericCommand {
    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public AccumulableCommand accumulate(Command other, Saver saver) {
        if (other instanceof IntCommand) {
            return sumWithOverflowCheck((IntCommand) other, saver);
        } else {
            throw new IllegalArgumentException("Can't accumulate ByteCommand with other Command subclass");
        }
    }

    private AccumulableCommand sumWithOverflowCheck(IntCommand other, Saver saver) {
        long sum = this.message + other.getMessage();

        if (sum > Integer.MAX_VALUE) {
            saver.save(getDecorated());
            return new IntCommand((int) other.getMessage());
        } else {
            return new IntCommand((int) sum);
        }
    }
}

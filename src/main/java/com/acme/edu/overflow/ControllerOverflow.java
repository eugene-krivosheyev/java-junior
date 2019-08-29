package com.acme.edu.overflow;


import com.acme.edu.commands.types.primitive.ByteCommand;
import com.acme.edu.commands.types.primitive.IntCommand;
import com.acme.edu.saver.ConsoleSaver;

public class ControllerOverflow {

   public static void controlOverflow(int value,  IntCommand command) throws OverflowException {
        if(value > 0 && Integer.MAX_VALUE - value <=  command.getMessage()) {
            new ConsoleSaver().saveWithPrefix(new IntCommand(Integer.MAX_VALUE));
            throw new OverflowException("Int overflow");
        }
        else if(value < 0 && Integer.MIN_VALUE - value >= command.getMessage()){ value = Integer.MIN_VALUE; }

        if (value == Integer.MAX_VALUE || value == Integer.MIN_VALUE) {
            new ConsoleSaver().saveWithoutPrefix(command);
            command.setMessage(value);
        } else { command.setMessage(command.getMessage() + value); }
    }



    public static void controlOverflow(byte value, ByteCommand command) throws OverflowException {
        if(value > 0 && Byte.MAX_VALUE - value <=  command.getMessage()) {
            new ConsoleSaver().saveWithPrefix(new ByteCommand(Byte.MAX_VALUE));
            throw new OverflowException("Byte overflow");
        }
        else if(value < 0 && Byte.MIN_VALUE - value >= command.getMessage()){ value = Byte.MIN_VALUE; }

        if (value == Byte.MAX_VALUE || value == Byte.MIN_VALUE) {
            new ConsoleSaver().saveWithoutPrefix(command);
            command.setMessage(value);
        } else {
            int b = command.getMessage() + value;
            command.setMessage((byte) b);
        }
    }
}

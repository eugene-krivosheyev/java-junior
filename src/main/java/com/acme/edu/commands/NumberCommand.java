package com.acme.edu.commands;
import com.acme.edu.savers.Saver;


/**
 * Created by kate-c on 26/08/2019.
 */
public abstract class NumberCommand extends Command {

    protected long message;

    public NumberCommand(long message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return "primitive: " + message;
    }


    public Command accumulatorTemplate(long message, long newMessage,
                                       long minValue, long maxValue,
                                       Saver saver,
                                       Command accumulatedCommand, Command newCommand) {
        long currentMessageToLong = message;
        try {
            if (currentMessageToLong + newMessage > maxValue || currentMessageToLong + newMessage < minValue) {
                throw new ArithmeticException("Overflow!");
            }
        }
        catch(ArithmeticException e) {
            e.printStackTrace();
            this.flush(saver);
            return newCommand;
        }
        return accumulatedCommand;
    }

}


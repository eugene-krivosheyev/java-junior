package com.acme.edu.accumulateCommands;

import com.acme.edu.savers.Saver;

public interface AccumulateCommand {
    AccumulateCommand accumulate(AccumulateCommand prevCommand, Saver saver);
    void flush(Saver saver);
    static boolean isTypeTheSame(AccumulateCommand command1, AccumulateCommand command2){
        return command1.getClass().equals(command2.getClass());
    }
}

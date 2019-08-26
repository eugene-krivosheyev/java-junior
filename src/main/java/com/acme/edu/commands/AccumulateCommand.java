package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

public interface AccumulateCommand extends DecorateCommand {
    AccumulateCommand accumulate(AccumulateCommand prevCommand, Saver saver);
    void flush(Saver saver);
    static boolean isTypeTheSame(AccumulateCommand command1, AccumulateCommand command2){
        return command1.getClass().equals(command2.getClass());
    }
}

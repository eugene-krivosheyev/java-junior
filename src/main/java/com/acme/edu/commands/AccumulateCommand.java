package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

public abstract class AccumulateCommand implements DecorateCommand {
    public abstract AccumulateCommand accumulate(AccumulateCommand prevCommand, Saver saver);
    public abstract void flush(Saver saver);
    public boolean isTypeTheSame(AccumulateCommand command){
        return this.getClass().equals(command.getClass());
    }
}

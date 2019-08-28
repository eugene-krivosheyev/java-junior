package com.acme.edu.commands;

import com.acme.edu.exceptions.SaverException;
import com.acme.edu.savers.Saver;

public abstract class AccumulateCommand implements DecorateCommand {
    public abstract AccumulateCommand accumulate(AccumulateCommand prevCommand, Saver saver) throws SaverException;
    public abstract void flush(Saver saver) throws SaverException;
    public boolean isTypeTheSame(AccumulateCommand command){
        return this.getClass().equals(command.getClass());
    }
}

package com.acme.edu;

import com.acme.edu.commands.AccumulateCommand;
import com.acme.edu.commands.DecorateCommand;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Stateless, Application scope
 */
public class LoggerController {
    private Saver saver;
    @Nullable
    private AccumulateCommand prevCommand;

    public LoggerController(){
        saver = new ConsoleSaver();
    }

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public LoggerController(Saver saver, @Nullable AccumulateCommand accumulate) {
        this.saver = saver;
        this.prevCommand = accumulate;
    }

    public void run(@NotNull DecorateCommand decorateCommand) throws SaverException {
        if (prevCommand != null) {
            prevCommand.flush(saver);
        }
        String decoratedMessage = decorateCommand.decorate();
        saver.save(decoratedMessage);
    }

    public void run(@NotNull AccumulateCommand accumulateCommand) throws SaverException {
        if (prevCommand == null) {
            prevCommand = accumulateCommand;
        } else if (prevCommand.isTypeTheSame(accumulateCommand)) {
            prevCommand = accumulateCommand.accumulate(prevCommand, saver);
        } else {
            prevCommand.flush(saver);
            prevCommand = accumulateCommand;
        }
    }

    public void close() throws SaverException {
        if (prevCommand != null) {
            prevCommand.flush(saver);
            prevCommand = null;
        }
    }
}
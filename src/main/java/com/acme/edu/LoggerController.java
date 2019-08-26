package com.acme.edu;

import com.acme.edu.commands.AccumulateCommand;
import com.acme.edu.commands.DecorateCommand;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.acme.edu.commands.AccumulateCommand.isTypeTheSame;

public class LoggerController {
    private Saver saver = new ConsoleSaver();
    @Nullable
    private AccumulateCommand prevCommand;

    public void run(@NotNull DecorateCommand decorateCommand) {
        if (prevCommand != null) {
            prevCommand.flush(saver);
        }
        saver.save(decorateCommand.decorate());
    }

    public void run(@NotNull AccumulateCommand accumulateCommand) {
        if (prevCommand == null) {
            prevCommand = accumulateCommand;
        } else if (isTypeTheSame(accumulateCommand, prevCommand)) {
            prevCommand = accumulateCommand.accumulate(prevCommand, saver);
        } else {
            prevCommand.flush(saver);
            prevCommand = accumulateCommand;
        }
    }

    public void close(){
        if (prevCommand != null) {
            prevCommand.flush(saver);
        }
        prevCommand = null;
    }
}
package com.acme.edu;

import com.acme.edu.accumulateCommands.AccumulateCommand;
import com.acme.edu.decorateComands.DecorateCommand;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;

public class LoggerController {
    private static Saver saver = new ConsoleSaver();
    private AccumulateCommand prevCommand = null;

    public void run(DecorateCommand decorateCommand) {
        if (prevCommand != null) {
            prevCommand.flush(saver);
        }
        saver.save(decorateCommand.decorate());
    }

    public void run(AccumulateCommand accumulateCommand) {
        if (prevCommand == null) {
            prevCommand = accumulateCommand;
        } else if (accumulateCommand.getClass().equals(prevCommand.getClass())) {
            prevCommand = accumulateCommand.accumulate(prevCommand, saver);
        } else {
            prevCommand.flush(saver);
            prevCommand = accumulateCommand;
        }
    }

    public void close(){
        prevCommand.flush(saver);
        prevCommand = null;
    }
}
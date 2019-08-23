package com.acme.edu;

import com.acme.edu.accumulateCommands.AccumulateCommand;
import com.acme.edu.decorateComands.DecorateCommand;

public class LoggerController {
    private static Printer printer = new Printer();
    private static AccumulateCommand prevCommand = null;

    public void run(DecorateCommand decorateCommand) {
        if (prevCommand != null) {
            prevCommand.flush(printer);
        }
        printer.save(decorateCommand.decorate());
    }

    public void run(AccumulateCommand accumulateCommand) {
        if (prevCommand == null) {
            prevCommand = accumulateCommand;
        } else if (accumulateCommand.getClass().equals(prevCommand.getClass())) {
            prevCommand = accumulateCommand.accumulate(prevCommand, printer);
        } else {
            prevCommand.flush(printer);
            prevCommand = accumulateCommand;
        }
    }

    public void close(){
        prevCommand.flush(printer);
        prevCommand = null;
    }
}
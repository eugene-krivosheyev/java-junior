package com.acme.edu;

import com.acme.edu.commands.AccumulableCommand;
import com.acme.edu.commands.Command;
import com.acme.edu.savers.Saver;

import java.util.Collection;
import java.util.LinkedList;

class LoggerController {
    private Saver saver;
    private Collection<AccumulableCommand> accumulationBuffer = new LinkedList<>();

    LoggerController(Saver saver) {
        this.saver = saver;
    }

    void submit(Command command) {
        if (command instanceof AccumulableCommand) {
            processAccumulableCommand((AccumulableCommand) command);
        } else {
            processSimpleCommand(command);
        }
    }

    void flush() {
        flushAccumulationBuffer();
    }

    private void processSimpleCommand(Command command) {
        flushAccumulationBuffer();
        saver.save(command.getDecorated());
    }

    private void processAccumulableCommand(AccumulableCommand command) {
        if (!accumulationBuffer.isEmpty() && !accumulationBuffer.iterator().next().getClass().equals(command.getClass())) {
            flushAccumulationBuffer();
        }
        accumulationBuffer.add(command);
    }

    private void flushAccumulationBuffer() {
        if (!accumulationBuffer.isEmpty()) {
            accumulationBuffer.stream()
                    .reduce((c1, c2) -> c1.accumulate(c2, saver))
                    .ifPresent(accumulatedCommand -> saver.save(accumulatedCommand.getDecorated()));

            accumulationBuffer.clear();
        }
    }
}

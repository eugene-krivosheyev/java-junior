package com.acme.edu;

import com.acme.edu.commands.AccumulateCommand;
import com.acme.edu.commands.DecorateCommand;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.Saver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Stateless, Application scope
 */
public class LoggerController {
    private Saver saver;
    @Nullable
    private static DecorateCommand lastCommand;
    private static Collection<DecorateCommand> commandsBuffer = new LinkedList<>();


    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public LoggerController(Saver saver, @Nullable AccumulateCommand accumulate) {
        this.saver = saver;
        lastCommand = accumulate;
    }

    public void run(@NotNull DecorateCommand decorateCommand) throws SaverException {
        if (lastCommand != null && isFlushNeeded(decorateCommand)) {
            flushDecoratedBuffer();
        }
        commandsBuffer.add(decorateCommand);
        lastCommand = decorateCommand;
    }

    public void run(@NotNull AccumulateCommand accumulateCommand) throws SaverException {
        if (lastCommand != null) {
            if (!lastCommand.getClass().equals(AccumulateCommand.class)) {
                flushDecoratedBuffer();
            } else if (!((AccumulateCommand) lastCommand).isTypeTheSame(accumulateCommand)) {
                flushAccumulatedBuffer();
            }
        }
        lastCommand = accumulateCommand;
        commandsBuffer.add(accumulateCommand);
    }

    private boolean isFlushNeeded(DecorateCommand newCommand) {
        if (commandsBuffer.size() == 0) {
            return false;
        }
        return !(lastCommand != null && lastCommand.getClass().equals(newCommand.getClass()));
    }

    private void flushDecoratedBuffer() {
        commandsBuffer.forEach(command -> saver.save(command.decorate()));
        commandsBuffer.clear();
    }

    private void flushAccumulatedBuffer() {
        if (lastCommand != null) {
            commandsBuffer.stream()
                    .reduce((accumulatedCommand, command) ->
                            ((AccumulateCommand) accumulatedCommand).accumulate((AccumulateCommand) command, saver))
                    .ifPresent(result -> ((AccumulateCommand) result).flush(saver));
            commandsBuffer.clear();
        }
    }

    public void close() throws SaverException {
        if (lastCommand != null) {
            ((AccumulateCommand) lastCommand).flush(saver);
            lastCommand = null;
        }
        flushAccumulatedBuffer();
    }
}
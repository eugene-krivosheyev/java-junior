package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.savers.ConsoleSaver;
import com.acme.edu.savers.FileSaver;
import com.acme.edu.savers.Saver;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Created by kate-c on 23/08/2019.
 */
public class LoggerController {
    private Saver saver = new FileSaver(5);
    @Nullable
    private Command previousCommand = null;
    private Queue<Command> commandBuffer = new LinkedList<>();

    public LoggerController() {
    }

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void log(Command newCommand) {
        if (previousCommand != null && !previousCommand.isTypeEqual(newCommand)) {
            flush();
        }
        commandBuffer.add(newCommand);
        previousCommand = newCommand;
    }

    public void flush() {
        if (commandBuffer.isEmpty()) {
            return;
        }
        try {
            Optional<Command> accumulatedCommand = commandBuffer.stream()
                    .reduce((command, command2) -> command.accumulate(command2, saver));
            accumulatedCommand.orElseThrow(() -> new Exception()).flush(saver);
            commandBuffer = new LinkedList<>();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

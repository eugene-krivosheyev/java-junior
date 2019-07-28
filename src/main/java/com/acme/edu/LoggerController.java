package com.acme.edu;

import com.acme.edu.command.Command;
import com.acme.edu.saver.Saver;

import java.util.Map;
import java.util.HashMap;

public class LoggerController {
    private static LoggerController theOnlyLogger = new LoggerController();
    private Map<String, Boolean> commandParameters = new HashMap<>();
    private Command previousCommand;
    private Saver saver;

    private LoggerController() {
        resetCommandParameters();
    }

    public static LoggerController getTheOnlyLogger() {
        return theOnlyLogger;
    }

    public void send(Command command) {
        String result = command.process(commandParameters, previousCommand);
        previousCommand = command;
        saver.save(result);
    }

    public void setSaver(Saver saver) {
        this.saver = saver;
    }

    public void setAccumulateCommandParameter(boolean accumulate) {
        commandParameters.put("accumulate", accumulate);
    }

    public void setDecorateCommandParameter(boolean decorate) {
        commandParameters.put("decorate", decorate);
    }


    public void setPreviousCommand(Command previousCommand) {
        this.previousCommand = previousCommand;
    }

    public void resetCommandParameters() {
        setAccumulateCommandParameter(false);
        setDecorateCommandParameter(false);
        setPreviousCommand(null);
    }

    public void flush() {
        String result = previousCommand.flush();
        saver.save(result);
    }
}

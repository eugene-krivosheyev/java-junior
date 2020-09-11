package com.acme.edu.saver;

import com.acme.edu.command.LoggerCommand;
import com.acme.edu.exception.SaveException;

public interface LoggerSaver {
    public void saveMessage(LoggerCommand message) throws SaveException;
}

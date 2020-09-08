package com.acme.edu.saver;

import com.acme.edu.command.LoggerCommand;

public interface LoggerSaver {
    public void saveMessage(LoggerCommand message);
}

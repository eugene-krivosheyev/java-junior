package com.acme.edu.saver;

import com.acme.edu.command.LoggerCommand;

public class ConsoleSaver {
    public void saveMessage(LoggerCommand message) {
        System.out.println(message);
    }
}

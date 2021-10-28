package com.acme.edu.net.server;

import com.acme.edu.net.server.commands.LogCommand;

public interface LogCommandCreator {
    LogCommand create(String argument);
}

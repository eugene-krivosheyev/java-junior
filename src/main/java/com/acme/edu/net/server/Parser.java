package com.acme.edu.net.server;

import com.acme.edu.LoggerController;
import com.acme.edu.common.Message;
import com.acme.edu.net.server.commands.*;

import java.util.HashMap;

public class Parser {
    private HashMap<String, LogCommandCreator> commandCreators = new HashMap<>();

    Message message;

    public Parser() {
        commandCreators.put("flush", (String key) -> new FlushCommand());
        commandCreators.put("int", (String argument) ->
                new IntCommand(Integer.parseInt(argument)));
        commandCreators.put("byte", (String argument) ->
                new ByteCommand(Byte.parseByte(argument)));
        commandCreators.put("string", StringCommand::new);
        commandCreators.put("char", (String argument) -> {
            if (argument.length() != 1) {
                throw new IllegalArgumentException("Character format is illegal");
            }
            return new CharCommand(argument.charAt(0));
        });
    }
    LogCommand parse(String command) {
        String[] strings = command.split(",");
        if (strings.length < 1) {
            throw new IllegalArgumentException("Could not parse.");
        }
        String commandName = strings[0];
        LogCommandCreator creator = commandCreators.get(commandName);
        if (creator == null) {
            throw new IllegalArgumentException("Could not parse command name.");
        }
        if (commandName.equals("flush")) {
            return creator.create("");
        }
        if (strings.length != 2) {
            throw new IllegalArgumentException("Command must contain one argument.");
        }
        String argument = strings[1];
        return creator.create(argument);
    }
}

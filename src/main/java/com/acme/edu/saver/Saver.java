package com.acme.edu.saver;

import com.acme.edu.commands.Command;

public interface Saver {
    void saveWithoutPrefix(Command command) throws SaverException;
    void saveWithPrefix(Command command) throws SaverException;
}

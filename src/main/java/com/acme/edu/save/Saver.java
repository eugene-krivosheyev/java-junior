package com.acme.edu.save;

import com.acme.edu.command.Command;
import com.acme.edu.exceptions.SaveException;

import java.io.IOException;

public interface Saver {
    void save(Command cmd) throws IOException, SaveException;
}

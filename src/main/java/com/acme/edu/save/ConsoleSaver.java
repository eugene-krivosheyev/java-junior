package com.acme.edu.save;

import com.acme.edu.command.Command;
import com.acme.edu.save.Saver;

public class ConsoleSaver implements Saver {
    @Override
    public void save(Command cmd) {
        System.out.println(cmd);
    }
}

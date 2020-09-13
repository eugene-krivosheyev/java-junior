package com.acme.edu.save;

import com.acme.edu.command.Command;

public class ConsoleSaver implements Saver {
    @Override
    public void save(Command cmd) {
        System.out.println(cmd);
    }
}

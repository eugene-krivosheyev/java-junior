package com.acme.edu.saver;

import com.acme.edu.commands.Command;

public class ConsoleSaver implements Saver {

    @Override
    public void saveWithoutPrefix(Command command) {
        System.out.println(command.getMessage());
    }

    @Override
    public void saveWithPrefix(Command command) {
        System.out.println(command.decorate());
    }

}

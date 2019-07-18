package com.acme.edu.saver;

import com.acme.edu.Accumulator;
import com.acme.edu.command.Command;

public class ConsoleLoggerSaver {
    public void save(Command command){
        System.out.println(command.messageDecorate());
    }
}

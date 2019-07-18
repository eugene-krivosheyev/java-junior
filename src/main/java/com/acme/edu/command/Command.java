package com.acme.edu.command;

import com.acme.edu.Accumulator;
import com.acme.edu.Type;

public interface Command {
    boolean accumulate(Command accumulator);
    Type getType();
    String messageDecorate();
}

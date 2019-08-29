package com.acme.edu.mylogger;

import java.util.Collection;
import java.util.Optional;
import java.util.Queue;

public interface SuperAccumulator {
    Optional<Command> accumulate(Queue<Command> collection);
    int getPrevSum();
}

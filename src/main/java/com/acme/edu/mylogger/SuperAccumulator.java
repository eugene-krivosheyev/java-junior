package com.acme.edu.mylogger;

import java.util.Optional;
import java.util.Queue;

public interface SuperAccumulator {
    Optional<Command> accumulate(Queue<Command> collection);
    void addToQueue(Command command);
    void clearQueue();
    Queue<Command> getCommandQueue();
}

package com.acme.edu.mylogger;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class SuperCurrentAccumulator implements SuperAccumulator {
    private Queue<Command> commandQueue = new LinkedList<>();

    @Override
    public Optional<Command> accumulate(Queue<Command> collection) {
        try {
            collection.stream().reduce(Command::accumulate);
        } catch (ArithmeticException e) {
            throw new ArithmeticException(e.getLocalizedMessage());
        }
        return collection.stream().reduce(Command::accumulate);
    }

    @Override
    public void addToQueue(Command command) {
        try {
            Queue<Command> newQueue = new LinkedList<>(commandQueue);
            newQueue.add(command);
            newQueue.stream().reduce(Command::accumulate);
        } catch (ArithmeticException e) {
            throw new ArithmeticException(e.getLocalizedMessage());
        } finally {
            commandQueue.add(command);
        }
    }

    @Override
    public void clearQueue() {
        commandQueue.clear();
    }

    @Override
    public Queue<Command> getCommandQueue() {
        return commandQueue;
    }
}

package com.acme.edu.command;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public abstract class CommonCommand<T> implements Command<T> {
    @Override
    public String process(Map<String, Boolean> commandParameters, Command previousCommand) {
        boolean toAccumulate = commandParameters.getOrDefault("accumulate", false);
        if (toAccumulate) {
            return accumulate(previousCommand);
        }
        return decorate(commandParameters);
    }

    @Override
    public abstract T getMessage();

    @Override
    public int getCounter() {
        return 0;
    }

    public String decorate(Map<String, Boolean> commandParameters) {
        boolean toDecorate = commandParameters.getOrDefault("decorate", false);
        return concreteDecoration(toDecorate);
    }

    public String accumulate(Command previousCommand) {
        if (Objects.isNull(previousCommand)) {
            return null;
        }
        boolean toFlush = !Objects.equals(this.getClass(), previousCommand.getClass());
        if (toFlush) {
            return previousCommand.flush();
        }
        return concreteAccumulation(previousCommand);
    }

    @Override
    public String flush() {
        return getMessage().toString();
    }

    protected abstract String concreteDecoration(boolean toDecorate);

    protected abstract String concreteAccumulation(Command previousCommand);
}

package com.acme.edu.observerdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Context {
    private List<EventHandler> handlers = new ArrayList<>();

    public Context(EventHandler... handlers) {
        this.handlers.addAll(asList(handlers));
    }

    public void logEvent() {
        handlers.forEach(EventHandler::handleEvent);
    }
}

@FunctionalInterface
interface EventHandler {
    void handleEvent();
}

class FormattingSavingHandler implements EventHandler {
    @Override
    public void handleEvent() {

    }
}

class ConsoleEventHandler implements EventHandler {
    @Override
    public void handleEvent() {

    }
}

class LoggerFacade {
    public static void main(String[] args) {
        new Context(
                new FormattingSavingHandler(),
                () -> System.out.println()
        );
    }
}


package demo.ooad.controller;

import demo.ooad.dao.SaveException;
import demo.ooad.domain.Message;
import demo.ooad.filter.Filter;
import demo.ooad.dao.Saver;

public class LoggerController {
    private final Filter filter; // [GRASP] Creator
    private final Saver saver; // [GoF] Factory Method

    /**
     * Constructor DI
     * @param filter
     * @param saver
     */
    public LoggerController(Filter filter, Saver saver) {
        this.filter = filter;
        this.saver = saver;
    }


    /**
     * Public API
     * @param message
     *
     * Polymorphism in Java:
     * A a = new B();
     * a.m();
     *
     */
    public void log(Message message) throws SaveException {
        if (message == null ||
            message.getBody() == null ||
            message.getBody().isEmpty()) {
                throw new IllegalArgumentException("not valid message to log!");
        }


        if (!filter.filter(message)) {
            try {
                saver.save(message);
            } catch (SaveException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }
}

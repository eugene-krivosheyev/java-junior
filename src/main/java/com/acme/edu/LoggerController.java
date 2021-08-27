package com.acme.edu;
import com.acme.edu.filters.Filter;
import com.acme.edu.messages.*;
import com.acme.edu.checkers.*;
import com.acme.edu.savers.Saver;


public class LoggerController {
    private final Saver saver;
    private final Filter filter;
    private final IntSequenceChecker intChecker;
    private final StringSequenceChecker stringChecker;

    public LoggerController(Saver saver, Filter filter) {
        this.saver = saver;
        this.filter = filter;
        this.intChecker = new IntSequenceChecker(this.saver);
        this.stringChecker = new StringSequenceChecker(this.saver);
        this.saver.setCheckers(intChecker, stringChecker);
    }

    public void log(Message message) {
        try {
            if (!filter.filter(message)) {
                saver.save(message);
            }
        }
        catch (IllegalAccessException err) {
            System.out.println(err.getMessage());
        }
    }

    public void flush(){
        stringChecker.check(null);
        intChecker.check(null);
    }
}
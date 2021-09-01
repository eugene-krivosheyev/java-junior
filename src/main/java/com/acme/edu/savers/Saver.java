package com.acme.edu.savers;

import com.acme.edu.checkers.IntSequenceChecker;
import com.acme.edu.checkers.StringSequenceChecker;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.messages.Message;

public interface Saver {
    void save(Message message);

    void setCheckers(IntSequenceChecker intChecker, StringSequenceChecker stringChecker);

    void close() throws SaverException;

    void flush();
}

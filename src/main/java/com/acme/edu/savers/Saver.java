package com.acme.edu.savers;

import com.acme.edu.checkers.IntSequenceChecker;
import com.acme.edu.checkers.StringSequenceChecker;
import com.acme.edu.messages.Message;

public interface Saver {
    void save(String message);

    void save(Message message);

    void setCheckers(IntSequenceChecker intChecker, StringSequenceChecker stringChecker);
}

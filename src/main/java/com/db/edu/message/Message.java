package com.db.edu.message;

import com.db.edu.saver.ConsoleSaver;
import com.db.edu.saver.Saver;

public interface Message {
    Saver saver = new ConsoleSaver();

    Object accumulate(Object type);
}

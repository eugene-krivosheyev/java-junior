package com.db.education.app.saver;

import com.db.education.app.exception.SaveException;
import com.db.education.app.message.Message;

public interface Saver {
    void save(Message message) throws SaveException;
}

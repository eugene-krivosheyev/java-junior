package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

import java.io.Serializable;

/**
 * Created by kate-c on 23/08/2019.
 */
public abstract class Command {
    public abstract Object getMessage();

    public abstract Command accumulate(Command command, Saver saver);

    public abstract String decorate();

    public abstract boolean isTypeEqual(Command other);

    public void flush(Saver saver) {
        saver.save(this.decorate());
    }
}

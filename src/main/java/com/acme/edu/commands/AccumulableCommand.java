package com.acme.edu.commands;

import com.acme.edu.savers.Saver;

public interface AccumulableCommand extends Command {
    AccumulableCommand accumulate(Command other, Saver saver);
}

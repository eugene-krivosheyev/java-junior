package com.acme.edu.accumulateCommands;

import com.acme.edu.savers.Saver;

public interface AccumulateCommand {
    AccumulateCommand accumulate(AccumulateCommand prevCommand, Saver saver);
    void flush(Saver saver);
}

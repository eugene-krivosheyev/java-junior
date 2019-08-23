package com.acme.edu.accumulateCommands;

import com.acme.edu.Printer;

public interface AccumulateCommand {
    AccumulateCommand accumulate(AccumulateCommand prevCommand, Printer printer);
    void flush(Printer printer);
}

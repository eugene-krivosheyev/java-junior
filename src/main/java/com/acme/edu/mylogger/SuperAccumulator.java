package com.acme.edu.mylogger;

import java.util.Collection;

public interface SuperAccumulator {
    int accumulate(Collection<Command> collection);
    int getPrevSum();
}

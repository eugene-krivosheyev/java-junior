package com.acme.edu.mylogger;

import java.util.Collection;
import java.util.Optional;

public interface SuperAccumulator {
    Optional<Command> accumulate(Collection<Command> collection);
    int getPrevSum();
}

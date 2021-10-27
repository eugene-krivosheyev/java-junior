package message;

import accumulator.Accumulator;

public interface Message {
    Object getBody();

    Accumulator getAccumulator();
}

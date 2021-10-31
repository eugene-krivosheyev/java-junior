package message;

import accumulator.Accumulator;

import java.io.Serializable;

public interface Message extends Serializable {
    Object getBody();

    Accumulator getAccumulator();
}

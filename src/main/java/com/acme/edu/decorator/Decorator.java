package com.acme.edu.decorator;

import com.acme.edu.message.*;

public interface Decorator {
    void decorate(IntMessage message);
    void decorate(StringMessage message);
    void decorate(BooleanMessage message);
    void decorate(CharMessage message);
    void decorate(ObjectMessage message);
    void decorate(Array1DMessage message);
    void decorate(MatrixMessage message);
    void decorate(ByteMessage message);
}

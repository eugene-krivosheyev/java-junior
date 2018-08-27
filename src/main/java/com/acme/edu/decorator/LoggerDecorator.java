package com.acme.edu.decorator;

import com.acme.edu.message.*;

public interface LoggerDecorator {
    String decorate (IntMessage message);

    String decorate (ByteMessage message);

    String decorate (CharMessage message);

    String decorate (ArrayIntMessage message);

    String decorate(BooleanMessage message);

    String decorate(MatrixIntMessage message);

    String decorate(ObjectMessage message);

    String decorate(StringMessage message);
}

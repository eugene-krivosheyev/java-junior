package com.acme.edu.decorator;

import com.acme.edu.message.ArrayIntMessage;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.CharMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.BooleanMessage;
import com.acme.edu.message.MatrixIntMessage;
import com.acme.edu.message.ObjectMessage;
import com.acme.edu.message.StringMessage;

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

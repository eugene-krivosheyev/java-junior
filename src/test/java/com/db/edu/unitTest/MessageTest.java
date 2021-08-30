package com.db.edu.unitTest;

import com.db.edu.State;
import com.db.edu.message.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static com.db.edu.Logger.*;

public class MessageTest {

    @Test
    public void weCanGetValueFromMessage() {
        Message message1 = new BooleanMessage(true);
        Message message2 = new IntMessage(7);
        Message message3 = new StringMessage("Hello");

        Assertions.assertEquals("true7Hello", message1.getValue()
                + message2.getValue()
                + message3.getValue());
    }

    @Test
    public void weCanGetDecoratedStringFromMessage() {
        Message message1 = new ByteMessage((byte)1);
        Message message2 = new CharMessage('a');
        Message message3 = new ObjectMessage("Hello");

        Assertions.assertEquals(PRIMITIVE_PREFIX + "1"
                + CHAR_PREFIX + "a"
                + REFERENCE_PREFIX + "Hello",
                message1.decorated() +
                message2.decorated() +
                message3.decorated());
    }

    @Test
    public void weCanAccumulateIntegersAndStrings() {
        Message message1 = new IntMessage(4);
        Message message2 = new StringMessage("Hi");

        message1.accumulate(new IntMessage(6));
        message2.accumulate(new StringMessage("Hi"));

        Assertions.assertTrue(message1.getValue().equals("10") &&
                (message2.getValue().equals("Hi")));
    }

    @Test
    public void weCanCheckStateIfMessageIsNotEmpty() {
        Message message = new IntMessage(5);

        Assertions.assertTrue(message.isNotEmpty() && message.getState() == State.INT);
    }

    @Test
    public void weCanCompareByteAndBooleanStates() {
        Message message1 = new BooleanMessage(true);
        Message message2 = new ByteMessage((byte)0);

        Assertions.assertFalse(message1.isStateEquals(message2));
    }

    @Test
    public void weCanCreateAndCanNotAccumulateEmptyMessage() {
        Message message = new EmptyMessage();

        //Assertions.assertFalse(message.accumulate(message));
    }
}



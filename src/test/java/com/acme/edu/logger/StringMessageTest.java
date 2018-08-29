package com.acme.edu.logger;

import com.acme.edu.message.StringMessage;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringMessageTest {

    @After
    public void clear(){
        StringMessage.arrayOfUniqueString.clear();
        StringMessage.arrayOfStrings.clear();
        StringMessage.amountOfString.clear();
    }

    @Test
    public void shouldAddNewString(){
        StringMessage testMessage = new StringMessage("test message");
        assertEquals(true, StringMessage.arrayOfUniqueString.contains("test message"));
    }

    @Test
    public void shouldNotAddNewString(){
        StringMessage firstMessage = new StringMessage("test message");
        StringMessage secondMessage = new StringMessage("test message");
        assertEquals(1, StringMessage.arrayOfUniqueString.size());
    }

    @Test
    public void shouldAccumulateEqualStrings(){
        StringMessage firstMessage = new StringMessage("test message");
        StringMessage secondMessage = new StringMessage("test message");
        assertEquals("string: test message (x2)" + System.lineSeparator(), firstMessage.accumulate(secondMessage).getDecoratedMessage());
    }

    @Test
    public void shouldELogDifferentStringsSeparately(){
        StringMessage firstMessage = new StringMessage("first message");
        StringMessage secondMessage = new StringMessage("second message");
        String accumulatedResult = firstMessage.accumulate(secondMessage).getDecoratedMessage();

        assertEquals(true, accumulatedResult.contains("first message"));
        assertEquals(true, accumulatedResult.contains("second message"));

    }
}

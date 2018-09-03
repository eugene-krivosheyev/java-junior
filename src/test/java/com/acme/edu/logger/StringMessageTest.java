package com.acme.edu.logger;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.message.StringMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringMessageTest implements SysoutCaptureAndAssertionAbility {

    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

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
        firstMessage.accumulate(secondMessage);

        assertEquals("string: test message (x2)" + System.lineSeparator(), secondMessage.getDecoratedMessage());
    }

    @Test
    public void shouldELogDifferentStringsSeparately(){
        StringMessage firstMessage = new StringMessage("first message");
        StringMessage secondMessage = new StringMessage("second message");
        firstMessage.accumulate(secondMessage);

        assertEquals("string: first message" + System.lineSeparator() + "second message" + System.lineSeparator(), secondMessage.getDecoratedMessage());

    }
}

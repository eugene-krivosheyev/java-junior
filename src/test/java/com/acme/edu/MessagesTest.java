package com.acme.edu;

import com.acme.edu.message.CharMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.ReferenceMessage;
import com.acme.edu.message.StringMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MessagesTest implements SysoutCaptureAndAssertionAbility {

    @Before
    public void setUp() {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldSayNotSameTypeWhenIntAndStringMessagesProvided() {
        IntMessage mockInt = spy(new IntMessage(1));
        StringMessage mockString = spy(new StringMessage("2"));

        boolean result = mockInt.isSameType(mockString);
        assertFalse(result);
    }

    @Test
    public void shouldSayNotSameTypeWhenIntAndCharProvided() {
        IntMessage mockInt = spy(new IntMessage(1));
        CharMessage mockChar = spy(new CharMessage('a'));

        boolean result = mockInt.isSameType(mockChar);
        assertFalse(result);
    }

    @Test
    public void shouldSayNotSameTypeWhenReferenceAndCharProvided() {
        ReferenceMessage mockRef = spy(new ReferenceMessage(new Object()));
        CharMessage mockChar = spy(new CharMessage('a'));

        boolean result = mockRef.isSameType(mockChar);
        assertFalse(result);
    }

    @Test
    public void shouldSayIsSameTypeWhenIntAndIntProvided() {
        IntMessage mockIntA = spy(new IntMessage(1));
        IntMessage mockIntB = spy(new IntMessage(2));

        boolean result = mockIntA.isSameType(mockIntB);
        assertTrue(result);
    }
}

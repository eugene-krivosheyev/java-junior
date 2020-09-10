package com.acme.edu;

import com.acme.edu.message.AbstractMessage;
import com.acme.edu.message.IntMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbstractMessageTest implements SysoutCaptureAndAssertionAbility{
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
    @Ignore //бред бредовый на самом деле
    public void shouldCallIsSameTypeForCorrectMessageType(){
        IntMessage intMock = mock(IntMessage.class);
        AbstractMessage messageMock = mock(AbstractMessage.class);

        when(intMock.isSameType(any())).thenReturn(true);

        if (intMock.isSameType(messageMock)) {
            System.out.println("int");
        }
        assertSysoutContains("int");
    }
}

package com.db.edu.utest.message;

import com.db.edu.message.IntMessage;
import com.db.edu.message.Message;
import com.db.edu.message.StringMessage;
import com.db.edu.saver.Saver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class IntMessageTest {

    @Test
    @Disabled
    void shouldAccumulateWhenMessageSameTypeOfInt() {
        Saver saveDummy = mock(Saver.class);
        IntMessage message1 = new IntMessage(1);
        IntMessage message2 = new IntMessage(2);

        message1.accumulate(message2);
        //verify(saveDummy, times(0)).save(any());
    }

    @Test
    @Disabled
    void shouldFlushWhenMessageNotSameTypeOfInt() {
        Saver saverMock = mock(Saver.class);
        IntMessage message1 = new IntMessage(1);
        //message1.flush();
//        when(saveDummy)
        //verify(saverMock, times(1)).save(any());
    }

    @Test
    void decorate() {
    }

    @Test
    void sameTypeOf() {
    }
}
package com.acme.edu.iteration04;

import com.acme.edu.exception.AccumulateException;
import com.acme.edu.exception.DecorateException;
import com.acme.edu.message.ByteMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ByteMessageTest {
    @Test
    public void shouldGetDecoratedMessageWhenConstructNewByteMessage() {
        //region Given
        ByteMessage sut;
        //endregion

        //region When
        sut = new ByteMessage((byte) 12);
        //endregion

        //region Then
        String expected = String.valueOf(12);
        String result = sut.getDecoratedString();
        assertEquals(expected, result);
        //endregion
    }

    @Test
    public void shouldReturnAccumulatedValueWhenAccumulateTwoMessages() throws AccumulateException, DecorateException {
        //region Given
        ByteMessage sut = new ByteMessage((byte) 12);
        ByteMessage additionMessage = new ByteMessage((byte) 13);
        //endregion

        //region When
        ByteMessage accumulatedMessage = (ByteMessage) sut.accumulate(additionMessage);
        accumulatedMessage = (ByteMessage) accumulatedMessage.decorate();
        //endregion

        //region Then
        assertTrue(accumulatedMessage.getDecoratedString().contains("25"));
        //endregion
    }

    @Test
    public void shouldReturnByteMessageTypeWhenInstanceOf() {
        //region Given
        ByteMessage sut = new ByteMessage((byte)12);
        //endregion

        //region When
        ByteMessage messageToCheckTypeWith = new ByteMessage((byte)13);
        //endregion

        //region Then
        assertTrue(sut.isInstanceOf(messageToCheckTypeWith));
        //endregion
    }
}

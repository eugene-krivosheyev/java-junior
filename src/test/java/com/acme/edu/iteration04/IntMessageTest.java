package com.acme.edu.iteration04;

import com.acme.edu.message.IntMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntMessageTest {
    @Test
    public void shouldGetDecoratedMessageWhenConstructNewIntMessage() {
        //region Given
        IntMessage sut;
        //endregion

        //region When
        sut = new IntMessage(12);
        //endregion

        //region Then
        String expected = String.valueOf(12);
        String result = sut.getDecoratedString();
        assertEquals(expected, result);
        //endregion
    }

    @Test
    public void shouldReturnAccumulatedValueWhenAccumulateTwoMessages() {
        //region Given
        IntMessage sut = new IntMessage(12);
        IntMessage additionMessage = new IntMessage(13);
        //endregion

        //region When
        IntMessage accumulatedMessage = (IntMessage) sut.accumulate(additionMessage);
        accumulatedMessage = (IntMessage) accumulatedMessage.decorate();
        //endregion

        //region Then
        assertTrue(accumulatedMessage.getDecoratedString().contains("25"));
        //endregion
    }

    @Test
    public void shouldReturnIntMessageTypeWhenInstanceOf() {
        //region Given
        IntMessage sut = new IntMessage(12);
        //endregion

        //region When
        IntMessage messageToCheckTypeWith = new IntMessage(13);
        //endregion

        //region Then
        assertTrue(sut.isInstanceOf(messageToCheckTypeWith));
        //endregion
    }
}

package com.acme.edu.iteration04;

import com.acme.edu.message.StringMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringMessageTest {
    @Test
    public void shouldGetDecoratedMessageWhenConstructNewStringMessage() {
        //region Given
        StringMessage sut;
        //endregion

        //region When
        sut = new StringMessage("a");
        //endregion

        //region Then
        String expected = String.valueOf("a");
        String result = sut.getDecoratedString();
        assertEquals(expected, result);
        //endregion
    }

    @Test
    public void shouldReturnAccumulatedValueWhenAccumulateTwoSameMessages() {
        //region Given
        StringMessage sut = new StringMessage("a");
        StringMessage additionMessage = new StringMessage("a");
        //endregion

        //region When
        StringMessage accumulatedMessage = (StringMessage) sut.accumulate(additionMessage);
        accumulatedMessage = (StringMessage) accumulatedMessage.decorate();
        //endregion

        //region Then
        assertTrue(accumulatedMessage.getDecoratedString().contains("string: a (x2)"));
        //endregion
    }

    @Test
    public void shouldReturnLastValueWhenAccumulateTwoDifferentMessages() {
        //region Given
        StringMessage sut = new StringMessage("a");
        StringMessage additionMessage = new StringMessage("b");
        //endregion

        //region When
        StringMessage accumulatedMessage = (StringMessage) sut.accumulate(additionMessage);
        accumulatedMessage = (StringMessage) accumulatedMessage.decorate();
        //endregion

        //region Then
        assertTrue(accumulatedMessage.getDecoratedString().contains("string: b"));
        //endregion
    }

    @Test
    public void shouldReturnStringMessageTypeWhenInstanceOf() {
        //region Given
        StringMessage sut = new StringMessage("a");
        //endregion

        //region When
        StringMessage messageToCheckTypeWith = new StringMessage("b");
        //endregion

        //region Then
        assertTrue(sut.isInstanceOf(messageToCheckTypeWith));
        //endregion
    }
}

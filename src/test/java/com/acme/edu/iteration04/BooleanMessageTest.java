package com.acme.edu.iteration04;

import com.acme.edu.DecorateException;
import com.acme.edu.message.BooleanMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class BooleanMessageTest {
    @Test
    public void shouldGetDecoratedMessageWhenConstructNewBooleanMessage() {
        //region Given
        BooleanMessage sut;
        //endregion

        //region When
        sut = new BooleanMessage(true);
        //endregion

        //region Then
        String expected = "true";
        String result = sut.getDecoratedString();
        assertEquals(expected, result);
        //endregion
    }

    @Test
    public void shouldReturnDecoratedValueWhenDecorateIsCalled() throws DecorateException {
        //region Given
        BooleanMessage sut = new BooleanMessage(true);
        //endregion

        //region When
        sut = (BooleanMessage) sut.decorate();
        //endregion

        //region Then
        assertTrue(sut.getDecoratedString().contains("primitive: true"));
        //endregion
    }

    @Test
    public void shouldNotChangeValueInMessageWhenAccumulateIsCalled() {
        //region Given
        BooleanMessage sut = new BooleanMessage(true);
        BooleanMessage mockBooleanMessage = mock(BooleanMessage.class);
        //endregion

        //region When
        sut = (BooleanMessage) sut.accumulate(mockBooleanMessage);
        //endregion

        //region Then
        assertTrue(sut.getDecoratedString().equals("true"));
        //endregion
    }

    @Test
    public void shouldReturnBooleanMessageTypeWhenInstanceOf() {
        //region Given
        BooleanMessage sut = new BooleanMessage(true);
        //endregion

        //region When
        BooleanMessage messageToCheckTypeWith = new BooleanMessage(false);
        //endregion

        //region Then
        assertTrue(sut.isInstanceOf(messageToCheckTypeWith));
        //endregion
    }
}

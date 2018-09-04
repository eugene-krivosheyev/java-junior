package com.acme.edu.iteration04;

import com.acme.edu.exception.DecorateException;
import com.acme.edu.message.CharMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class CharMessageTest {
    @Test
    public void shouldGetDecoratedMessageWhenConstructNewMessage() {
        //region Given
        CharMessage sut;
        //endregion

        //region When
        sut = new CharMessage('a');
        //endregion

        //region Then
        String expected = "a";
        String result = sut.getDecoratedString();
        assertEquals(expected, result);
        //endregion
    }

    @Test
    public void shouldReturnDecoratedValueWhenDecorateIsCalled() throws DecorateException {
        //region Given
        CharMessage sut = new CharMessage('a');
        //endregion

        //region When
        sut = (CharMessage) sut.decorate();
        //endregion

        //region Then
        assertTrue(sut.getDecoratedString().contains("char: a"));
        //endregion
    }

    @Test
    public void shouldNotChangeValueInMessageWhenAccumulateIsCalled() {
        //region Given
        CharMessage sut = new CharMessage('a');
        CharMessage mockCharMessage = mock(CharMessage.class);
        //endregion

        //region When
        sut = (CharMessage) sut.accumulate(mockCharMessage);
        //endregion

        //region Then
        assertTrue(sut.getDecoratedString().equals("a"));
        //endregion
    }

    @Test
    public void shouldReturnCharMessageTypeWhenInstanceOf() {
        //region Given
        CharMessage sut = new CharMessage('a');
        //endregion

        //region When
        CharMessage messageToCheckTypeWith = new CharMessage('b');
        //endregion

        //region Then
        assertTrue(sut.isInstanceOf(messageToCheckTypeWith));
        //endregion
    }
}

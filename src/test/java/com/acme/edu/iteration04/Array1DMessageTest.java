package com.acme.edu.iteration04;

import com.acme.edu.exception.DecorateException;
import com.acme.edu.message.Array1DMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class Array1DMessageTest {
    @Test
    public void shouldGetEmptyMessageWhenConstructNewMessage() {
        //region Given
        Array1DMessage sut;
        //endregion

        //region When
        sut = new Array1DMessage(new int[] {12});
        //endregion

        //region Then
        String expected = "";
        String result = sut.getDecoratedString();
        assertEquals(expected, result);
        //endregion
    }

    @Test
    public void shouldReturnDecoratedValueWhenDecorateIsCalled() throws DecorateException {
        //region Given
        Array1DMessage sut = new Array1DMessage(new int[] {12, 13});
        //endregion

        //region When
        sut = (Array1DMessage) sut.decorate();
        //endregion

        //region Then
        assertTrue(sut.getDecoratedString().contains("primitives array: {12, 13}"));
        //endregion
    }

    @Test
    public void shouldNotChangeDecoratedValueInMessageWhenAccumulateIsCalled() {
        //region Given
        Array1DMessage sut = new Array1DMessage(new int[] {12});
        Array1DMessage mockArray1DMessage = mock(Array1DMessage.class);
        //endregion

        //region When
        sut = (Array1DMessage) sut.accumulate(mockArray1DMessage);
        //endregion

        //region Then
        assertTrue(sut.getDecoratedString().equals(""));
        //endregion
    }

    @Test
    public void shouldReturnArray1DMessageTypeWhenInstanceOf() {
        //region Given
        Array1DMessage sut = new Array1DMessage(new int[] {12});
        //endregion

        //region When
        Array1DMessage messageToCheckTypeWith = new Array1DMessage(new int[] {13});
        //endregion

        //region Then
        assertTrue(sut.isInstanceOf(messageToCheckTypeWith));
        //endregion
    }
}

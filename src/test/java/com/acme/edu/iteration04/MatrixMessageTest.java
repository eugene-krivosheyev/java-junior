package com.acme.edu.iteration04;

import com.acme.edu.DecorateException;
import com.acme.edu.message.MatrixMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class MatrixMessageTest {
    @Test
    public void shouldGetEmptyMessageWhenConstructNewMessage() {
        //region Given
        MatrixMessage sut;
        //endregion

        //region When
        sut = new MatrixMessage(new int[][] {{12}});
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
        MatrixMessage sut = new MatrixMessage(new int[][] {{12, 13}});
        //endregion

        //region When
        sut = (MatrixMessage) sut.decorate();
        //endregion

        //region Then
        assertTrue(sut.getDecoratedString().contains("primitives matrix: {" + System.lineSeparator() +
                "{12, 13}" + System.lineSeparator() +
                "}" + System.lineSeparator()));
        //endregion
    }

    @Test
    public void shouldNotChangeDecoratedValueInMessageWhenAccumulateIsCalled() {
        //region Given
        MatrixMessage sut = new MatrixMessage(new int[][] {{12}});
        MatrixMessage mockMatrixMessage = mock(MatrixMessage.class);
        //endregion

        //region When
        sut = (MatrixMessage) sut.accumulate(mockMatrixMessage);
        //endregion

        //region Then
        assertTrue(sut.getDecoratedString().equals(""));
        //endregion
    }

    @Test
    public void shouldReturnMatrixMessageTypeWhenInstanceOf() {
        //region Given
        MatrixMessage sut = new MatrixMessage(new int[][] {{12}});
        //endregion

        //region When
        MatrixMessage messageToCheckTypeWith = new MatrixMessage(new int[][] {{12}});
        //endregion

        //region Then
        assertTrue(sut.isInstanceOf(messageToCheckTypeWith));
        //endregion
    }
}

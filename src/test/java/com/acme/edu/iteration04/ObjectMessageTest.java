package com.acme.edu.iteration04;


import com.acme.edu.DecorateException;
import com.acme.edu.message.ObjectMessage;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class ObjectMessageTest {
    
    @Test
    public void shouldGetDecoratedMessageWhenConstructNewObjectMessage() {
        //region Given
        ObjectMessage sut;
        //endregion

        //region When
        sut = new ObjectMessage(12);
        //endregion

        //region Then
        String expected = String.valueOf(12);
        String result = sut.getDecoratedString();
        assertEquals(expected, result);
        //endregion
    }

    @Test
    public void shouldReturnDecoratedValueWhenDecorateIsCalled() throws DecorateException {
        //region Given
        ObjectMessage sut = new ObjectMessage(new Object());
        //endregion

        //region When
        sut = (ObjectMessage) sut.decorate();
        //endregion

        //region Then
        String actualValue = sut.getDecoratedString();
        assertTrue(sut.getDecoratedString().contains("reference: "));
        assertTrue(sut.getDecoratedString().contains("@"));
        //endregion
    }

    @Test
    public void shouldNotChangeValueInMessageWhenAccumulateIsCalled() {
        //region Given
        ObjectMessage sut = new ObjectMessage('a');
        ObjectMessage mockObjectMessage = mock(ObjectMessage.class);
        //endregion

        //region When
        sut = (ObjectMessage) sut.accumulate(mockObjectMessage);
        //endregion

        //region Then
        assertTrue(sut.getDecoratedString().equals("a"));
        //endregion
    }

    @Test
    public void shouldReturnObjectMessageTypeWhenInstanceOf() {
        //region Given
        ObjectMessage sut = new ObjectMessage(12);
        //endregion

        //region When
        ObjectMessage messageToCheckTypeWith = new ObjectMessage(13);
        //endregion

        //region Then
        assertTrue(sut.isInstanceOf(messageToCheckTypeWith));
        //endregion
    }
    
}

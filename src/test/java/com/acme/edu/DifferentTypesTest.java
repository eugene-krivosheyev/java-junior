package com.acme.edu;

import com.acme.edu.message.DataEqualMessage;
import com.acme.edu.message.IllegalMessageExeption;
import com.acme.edu.message.type.IntMessage;
import com.acme.edu.message.type.StringMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DifferentTypesTest {
    @Test
    public void shouldSummingIntMessages() throws IllegalMessageExeption {

        IntMessage anotherIntMessage = mock(IntMessage.class);
        when(anotherIntMessage.isSameType(any(DataEqualMessage.class))).thenReturn(true);
        when(anotherIntMessage.isMAXMIN(any(DataEqualMessage.class))).thenReturn(false);
        when(anotherIntMessage.getData()).thenReturn(2);

        final IntMessage intMessage = new IntMessage(4,true);


        DataEqualMessage result = intMessage.add(anotherIntMessage);

        assertEquals(intMessage.getData(),6);
    }

    @Test
    public void shouldStopSummingIntWithDifferentType(){

        DataEqualMessage anotherIntMessage = mock(DataEqualMessage.class);

        final IntMessage intMessage = new IntMessage(4,true);

        try {
            intMessage.add(anotherIntMessage);
        } catch (IllegalMessageExeption thrown) {
            assertThat(thrown).hasMessage("Unexpected different type(Int) summing");
        }
    }

    @Test
    public void shouldSummingStringMessages() throws IllegalMessageExeption {

        StringMessage anotherStringMessage = mock(StringMessage.class);
        when(anotherStringMessage.isSameType(any(DataEqualMessage.class))).thenReturn(true);
        when(anotherStringMessage.isSame(any(DataEqualMessage.class))).thenReturn(true);
        when(anotherStringMessage.isMAXMIN(any(DataEqualMessage.class))).thenReturn(false);
        when(anotherStringMessage.getData()).thenReturn("MSG");

        StringMessage differentStringMessage = mock(StringMessage.class);
        when(differentStringMessage.isSame(any(DataEqualMessage.class))).thenReturn(false);
        when(differentStringMessage.getData()).thenReturn("disMSG");


        final StringMessage stringMessage = new StringMessage("MSG",true);

        stringMessage.add(anotherStringMessage);
        stringMessage.add(anotherStringMessage);

        DataEqualMessage result = stringMessage.add(differentStringMessage);

        assertEquals(result.toString(),"MSG (x3)");
    }

    @Test
    public void shouldStopSummingStringWithDifferentType(){

        DataEqualMessage anotherIntMessage = mock(DataEqualMessage.class);

        final StringMessage intMessage = new StringMessage("MSG",true);

        try {
            intMessage.add(anotherIntMessage);
        } catch (IllegalMessageExeption thrown) {
            assertThat(thrown).hasMessage("Unexpected different type(String) summing");
        }
    }

}

package com.acme.edu.demo;

import static junit.framework.Assert.assertEquals;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Test Case
 */
public class ArrayListTest {
    private ArrayList<Object> sut;

    @Before
    public void setUp() {
        sut = new ArrayList<>();
    }

    @Test
    public void shouldElementExistsAndSizeIncrementedWhenElementNewAdded() {
        //region Fixture | Given
        Object dummy = new Object();
        //endregion

        //region When
        sut.add(dummy);
        //endregion

        //region Then
        org.junit.Assert.assertEquals(1, sut.size());
        org.junit.Assert.assertTrue(sut.contains(dummy));

//        assertThat(sut, Matcher) //Hamcrest
        assertThat(sut) //Fluent Interface | API
                .hasSize(1)
                .contains(dummy);
        //endregion
    }

    @Test
    public void shouldUseElementsToStringWhenToString() {
        Object stub1 = mock(Object.class);
        when(stub1.toString())
                .thenReturn("test string 1")
                .thenReturn("test string 2");

        Object stub2 = mock(Object.class);
        when(stub2.toString()).thenReturn("test string 3"); //any(Saver.class) //anyString()

        sut.add(stub1);
        sut.add(stub2);

        String result = sut.toString();

        assertThat(result)
                .contains("test string 1")
                .contains("test string 3");
    }

    @Test @Ignore
    public void shouldCallElementsToStringWhenToString() {
        Object mock = mock(Object.class);
        sut.add(mock);

        sut.toString();

        verify(mock).toString(); //verify(mock).toString(1); verify(mock, times(1)).toString();
    }

}

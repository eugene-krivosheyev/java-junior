package com.acme.edu.demo;

import junit.framework.Assert;
import org.fest.assertions.Assertions;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test Case
 */
public class ArrayListTest {
    @Test
    public void shouldElementExistsAndSizeIncrementedWhenElementNewAdded() {
        //region Fixture | Given
        ArrayList<Object> sut = new ArrayList<>();
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
}

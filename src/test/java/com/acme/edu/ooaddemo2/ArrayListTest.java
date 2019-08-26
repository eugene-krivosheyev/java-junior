package com.acme.edu.ooaddemo2;

import org.fest.assertions.Assertions;
import org.junit.*;

import java.util.ArrayList;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

/**
 * Test-case
 */
public class ArrayListTest {
    private ArrayList<Object> sut;

    @Before //@After //@BeforeClass
    public void setUp() {
        sut = new ArrayList<>();
    }

    @Test
    public void shouldSizeIncreasedAndElementPresentAtTailWhenElementAdded() {
        //region Fixture | Arrange | Given
        Object dummy = new Object();
        assumeTrue(sut.isEmpty());
        //endregion

        //region Act | When
        sut.add(dummy);
        //endregion

        //region Then
        assertEquals( 1, sut.size());
        assertThat(sut)
                .hasSize(1)
                .containsExactly(dummy)
                .endsWith(dummy);

        /*
        Assert.assertThat(sut,
            allOf(
                    hasSize(1),
                    containsOnly(dummy)
        ));
         */
        //endregion
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenIndexOutOfRange() {
        sut.get(0);
    }
}

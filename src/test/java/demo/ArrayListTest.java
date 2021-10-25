package demo;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.anyOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

/**
 * SUT: System/Subject under test
 * Test case
 */
public class ArrayListTest {
    private List<Object> sut;
    private Object dummy;

    @BeforeEach
    public void setUp() {
        //region Arrange | Given | Fixture
        sut = new ArrayList<>();
        dummy = new Object();
        //endregion
    }

    /**
     * Main flow, happy path
     */
    @Test
    public void shouldStoreElementWhenAddNotNullElement() {
        //region Act | When
        sut.add(dummy);
        //endregion

        //region Assert | Then
        assertThat(sut, allOf(
                hasItem(dummy)
        ));

        org.assertj.core.api.Assertions.assertThat(sut).
                contains(dummy).
                hasSize(1);

//        assertAll();
//        assertTrue(sut.contains(dummy));
//        assertEquals(1, sut.size());
        //endregion
    }

    /**
     * Alternative flow, negative path
     */
    @Test
    public void shouldStoreElementWhenAddNullElement() {

    }
}

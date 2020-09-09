package demo.test;

import org.assertj.core.error.AssertionErrorMessagesAggregrator;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

public class ArrayListTests {
    @Test //BDD practice
    public void shouldContainsElementAndSizeIncrementedWhenElementAdd() {
        //region Fixture, Arrange, Given
        final ArrayList<Object> sut = new ArrayList<>();
        final Object dummy = new Object();
        assumeTrue(sut.size() == 0);
        //endregion

        //region Act | When
        sut.add(dummy);
        //endregion

        //region Assert | Then
        assertTrue(sut.contains(dummy));
        assertEquals("", 1, sut.size());
        //endregion
    }
}

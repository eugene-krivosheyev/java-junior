package demo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertSame;

public class ArrayListTest {
    @Test(timeout = 1_000)
    public void shouldContainElementAndSizeIncrementedWhenElementAdd() { //BDD, Cohesion, Contract
        //region Fixture | Arrange | Given
        ArrayList sut = new ArrayList();
        //endregion

        //region Act | When
        sut.add(new Object());
        //endregion

        //region Assert | Then
        assertEquals(1, sut.size());
        assertThat(sut.size()) //Fluent API interface
                .isEqualTo(1)
                .isPositive();
        //endregion
    }
}

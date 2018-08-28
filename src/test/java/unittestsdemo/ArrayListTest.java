package unittestsdemo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {
    @Test
    public void shouldAddElementWhenElementIsNull() {
        //region Given | Fixture
        ArrayList sut = new ArrayList();
        Object testObject = null;
        //endregion

        //region When
        sut.add(testObject);
        //endregion

        //region Then
        assertEquals(1, sut.size());
        assertNull(sut.get(0));
//        assertThat(sut)
//            .contains(null)
//            .hasSize(1);
        assertTrue(sut.get(0) == null);
        //endregion
    }
}

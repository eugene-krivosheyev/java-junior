package unit.tests;

import com.acme.edu.IntMessage;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

public class IntMessageTests {
    int sutIntValue;
    IntMessage sutIntMessage;

    @Before // @After | @BeforeClass @AfterClass
    public void setUp() {
        sutIntValue = 0;
        sutIntMessage = new IntMessage(sutIntValue);
        assumeTrue(sutIntMessage.getValue().equals(sutIntValue));
    }

    @Test
    public void shouldValueBeIncresedAfterAdd() {
        int newValue = (new Random()).nextInt(10);
        IntMessage newMessaege = new IntMessage(newValue);

        this.sutIntMessage.add(newMessaege);

        assertEquals(sutIntMessage.getValue(), newValue + sutIntValue);
    }

    @Test
    public void toStringShouldContainsPrefix() {
        assertEquals(sutIntMessage.toString(), "primitive: " + Integer.toString(sutIntValue));
    }


}

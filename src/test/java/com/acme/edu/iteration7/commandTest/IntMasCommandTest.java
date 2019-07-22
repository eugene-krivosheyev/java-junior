package com.acme.edu.iteration7.commandTest;

import com.acme.edu.Type;
import com.acme.edu.command.*;
import org.junit.Assert;
import org.junit.Test;


public class IntMasCommandTest {
    @Test
    public void shouldntAccumulateWhenTypeIntMas() {
        Command dummy1 = new IntMasCommand(new int[]{1, 2, 3, 4, 5, 6});
        Command dummy2 = new IntMasCommand(new int[]{1, 2, 3, 4, 5, 6});
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldGetType() {
        Command dummy1 = new IntMasCommand(new int[]{1, 2, 3, 4, 5, 6});
        Type result = dummy1.getType();

        assert result.equals(Type.INT_MAS);
    }

    @Test
    public void shouldDecorateIntMasMessageWhenMessageDecorate() {
        Command dummy1 = new IntMasCommand(new int[]{1, 2, 3, 4, 5, 6});
        String result = dummy1.messageDecorate();

        assert result.equals("primitives array: {1, 2, 3, 4, 5, 6}");
    }

    @Test
    public void shouldGetMessage() {
        Command dummy1 = new IntMasCommand(new int[]{1, 2, 3, 4, 5, 6});
        int[] result = ((IntMasCommand) dummy1).getIntMasValue();

        Assert.assertArrayEquals(result, new int[]{1, 2, 3, 4, 5, 6});
    }
}

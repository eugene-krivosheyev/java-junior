package com.acme.edu.iteration7.commandTest;

import com.acme.edu.Type;
import com.acme.edu.command.Command;
import com.acme.edu.command.IntMas2Command;
import org.junit.Assert;
import org.junit.Test;

public class IntMas2CommandTest {
    private String separator = System.lineSeparator();

    @Test
    public void shouldntAccumulateWhenTypeIntMas2() {
        Command dummy1 = new IntMas2Command((new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}}));
        Command dummy2 = new IntMas2Command((new int[][]{{1, 1, 2}, {2, 3, 3}, {-1, -2, -3}}));
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldGetType() {
        Command dummy1 = new IntMas2Command((new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}}));
        Type result = dummy1.getType();

        assert result.equals(Type.INT_MAS2);
    }

    @Test
    public void shouldDecorateIntMas2MessageWhenMessageDecorate() {
        Command dummy1 = new IntMas2Command((new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}}));
        String result = dummy1.messageDecorate();

        assert result.equals("primitives matrix: {" + separator +
                "{-1, 0, 1}" + separator +
                "{1, 2, 3}" + separator +
                "{-1, -2, -3}" + separator +
                "}");
    }

    @Test
    public void shouldDecorateIntMas2MessageWithZeroLengthArrayWhenMessageDecorate() {
        Command dummy1 = new IntMas2Command((new int[][]{{-1, 0, 1}, {}, {-1, -2, -3}}));
        String result = dummy1.messageDecorate();

        assert result.equals("primitives matrix: {" + separator +
                "{-1, 0, 1}" + separator +
                "{}" + separator +
                "{-1, -2, -3}" + separator +
                "}");
    }

    @Test
    public void shouldGetMessage() {
        Command dummy1 = new IntMas2Command((new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}}));
        int[][] result = ((IntMas2Command) dummy1).getIntMasValue();

        Assert.assertArrayEquals(result, new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
    }
}

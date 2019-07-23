package com.acme.edu.iteration7.commandTest;

import com.acme.edu.Type;
import com.acme.edu.command.Command;
import com.acme.edu.command.IntMas4Command;
import org.junit.Assert;
import org.junit.Test;

public class IntMas4CommandTest {
    private String separator = System.lineSeparator();

    @Test
    public void shouldntAccumulateWhenTypeIntMas4() {
        Command dummy1 = new IntMas4Command(new int[][][][]{{{{0}}}});
        Command dummy2 = new IntMas4Command(new int[][][][]{{{{0}}}});
        boolean result = dummy1.accumulate(dummy2);

        assert !result;
    }

    @Test
    public void shouldGetType() {
        Command dummy1 = new IntMas4Command(new int[][][][]{{{{0}}}});
        Type result = dummy1.getType();

        assert result.equals(Type.INT_MAS4);
    }

    @Test
    public void shouldDecorateCharMessageWhenMessageDecorate() {
        Command dummy1 = new IntMas4Command(new int[][][][]{{{{0}}}});
        String result = dummy1.messageDecorate();

        assert result.equals("primitives multimatrix: {" + separator +
                "{" + separator + "{" + separator + "{" +
                "0" +
                "}" + separator + "}" + separator + "}" + separator +
                "}");
    }

    @Test
    public void shouldDecorateIntMas2MessageWhenMessageDecorate() {
        Command dummy1 = new IntMas4Command(new int[][][][]{{{{}}}});
        String result = dummy1.messageDecorate();

        assert result.equals("primitives multimatrix: {" + separator +
                "{" + separator + "{" + separator + "{" +
                "}" + separator + "}" + separator + "}" + separator +
                "}");
    }

    @Test
    public void shouldGetMessage() {
        Command dummy1 = new IntMas4Command(new int[][][][]{{{{0}}}});
        int[][][][] result = ((IntMas4Command) dummy1).getIntMasValue();

        Assert.assertArrayEquals(result, new int[][][][]{{{{0}}}});
    }
}

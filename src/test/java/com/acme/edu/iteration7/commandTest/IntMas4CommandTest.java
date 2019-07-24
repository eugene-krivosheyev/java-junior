package com.acme.edu.iteration7.commandTest;

import com.acme.edu.command.*;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class IntMas4CommandTest {
    private String separator = System.lineSeparator();
    private int[][][][] mas1 = new int[][][][]{{{{0}}}};
    private int[][][][] mas2 = new int[][][][]{{{{}}}};

    private Object stub = mock(ConsoleLoggerSaver.class);
    private ConsoleLoggerSaver saver = new ConsoleLoggerSaver();

    @Before
    public void setUpObjects(){
    }

    @Test(expected = NullPointerException.class)
    public void shouldDownWhenNullSaver() throws IOException {
        Command sut = new IntMas4Command(mas1);

        sut.flush();
    }

    @Test
    public void shouldGetRightPrevCommandWhenIntMas2() throws IOException {
        Command sut1 = new IntMas4Command(mas1);
        Command sut2 = new IntMas4Command(mas2);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenOtherType() throws IOException {
        Command sut1 = new IntMas4Command(mas1);
        Command sut2 = new IntCommand(1);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenNone() throws IOException {
        Command sut1 = new NoneCommand();
        Command sut2 = new IntMas4Command(mas1);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldDecorateCharMessageWhenMessageDecorate() {
        Command dummy1 = new IntMas4Command(mas1);
        String result = dummy1.messageDecorate();

        assert result.equals("primitives multimatrix: {" + separator +
                "{" + separator + "{" + separator + "{" +
                "0" +
                "}" + separator + "}" + separator + "}" + separator +
                "}");
    }

    @Test
    public void shouldDecorateIntMas2MessageWhenMessageDecorate() {
        Command dummy1 = new IntMas4Command(mas2);
        String result = dummy1.messageDecorate();

        assert result.equals("primitives multimatrix: {" + separator +
                "{" + separator + "{" + separator + "{" +
                "}" + separator + "}" + separator + "}" + separator +
                "}");
    }

}

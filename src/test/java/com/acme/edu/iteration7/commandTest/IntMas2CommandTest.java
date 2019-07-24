package com.acme.edu.iteration7.commandTest;

import com.acme.edu.command.*;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class IntMas2CommandTest {
    private String separator = System.lineSeparator();
    private int[][] mas1 = new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}};
    private int[][] mas2 = new int[][]{{1, 1, 2}, {2, 3, 3}, {-1, -2, -3}};

    private Object stub = mock(ConsoleLoggerSaver.class);
    private ConsoleLoggerSaver saver = new ConsoleLoggerSaver();

    @Before
    public void setUpObjects(){
    }

    @Test(expected = NullPointerException.class)
    public void shouldDownWhenNullSaver() throws IOException {
        Command sut = new IntMas2Command(mas1);

        sut.flush();
    }

    @Test
    public void shouldGetRightPrevCommandWhenIntMas2() throws IOException {
        Command sut1 = new IntMas2Command(mas1);
        Command sut2 = new IntMas2Command(mas2);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenOtherType() throws IOException {
        Command sut1 = new IntMas2Command(mas1);
        Command sut2 = new IntCommand(1);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenNone() throws IOException {
        Command sut1 = new NoneCommand();
        Command sut2 = new IntMas2Command(mas1);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldDecorateBoolMessageWhenMessageDecorate(){
        Command command = new IntMas2Command(mas1);
        String result = command.messageDecorate();

        Assert.assertEquals(result,"primitives matrix: {" + separator +
                "{-1, 0, 1}" + separator +
                "{1, 2, 3}" + separator +
                "{-1, -2, -3}" + separator +
                "}");
    }

    @Test
    public void shouldDecorateIntMas2MessageWithZeroLengthArrayWhenMessageDecorate() {
        Command command = new IntMas2Command(new int[][]{{-1,0,1},{},{-1,-2,-3}});
        String result = command.messageDecorate();

        Assert.assertEquals(result,"primitives matrix: {" + separator +
                "{-1, 0, 1}" + separator +
                "{}" + separator +
                "{-1, -2, -3}" + separator +
                "}");
    }
}

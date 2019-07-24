package com.acme.edu.iteration7.commandTest;

import com.acme.edu.Type;
import com.acme.edu.command.*;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;


public class IntMasCommandTest {
    private String separator = System.lineSeparator();
    private int[] mas1 = new int[]{1, 2, 3, 4, 5, 6};
    private int[] mas2 = new int[]{1, 2, 3, 4, 5, 6};

    private Object stub = mock(ConsoleLoggerSaver.class);
    private ConsoleLoggerSaver saver = new ConsoleLoggerSaver();

    @Before
    public void setUpObjects(){
    }

    @Test(expected = NullPointerException.class)
    public void shouldDownWhenNullSaver() throws IOException {
        Command sut = new IntMasCommand(mas1);

        sut.flush();
    }

    @Test
    public void shouldGetRightPrevCommandWhenIntMas() throws IOException {
        Command sut1 = new IntMasCommand(mas1);
        Command sut2 = new IntMasCommand(mas2);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenOtherType() throws IOException {
        Command sut1 = new IntMasCommand(mas1);
        Command sut2 = new IntCommand(1);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenNone() throws IOException {
        Command sut1 = new NoneCommand();
        Command sut2 = new IntMasCommand(mas1);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldDecorateIntMasMessageWhenMessageDecorate() {
        Command dummy1 = new IntMasCommand(new int[]{1, 2, 3, 4, 5, 6});
        String result = dummy1.messageDecorate();

        Assert.assertEquals(result,"primitives array: {1, 2, 3, 4, 5, 6}");
    }
}

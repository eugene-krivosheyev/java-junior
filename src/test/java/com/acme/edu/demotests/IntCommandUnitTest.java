package com.acme.edu.demotests;

import com.acme.edu.command.IntCommand;
import com.acme.edu.save.Saver;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertTrue;

public class IntCommandUnitTest {
    IntCommand firstCmd;
    IntCommand secondCmd;

    @Before
    public void setUp() {
        firstCmd = new IntCommand(1);
        secondCmd = new IntCommand(5);
    }

    @Test
    public void shouldAccumulateIntCommand() {
        assertThat(firstCmd.reduce(secondCmd).decorate().equals("6"));
    }

    @Test
    public void shouldUnderstandWhenSameTypeCallIsSameType(){
        assertTrue(firstCmd.isSameType(secondCmd));
    }

    @Test
    public void shouldUnderstandWhenIntCommandIsOverflow() {
        IntCommand temp = new IntCommand(Integer.MAX_VALUE);
        assertTrue(firstCmd.isOverflow(temp));
    }

    @Test
    public void shouldDecorateIntCommandWithToString() {
        Saver saver = System.out::println;

        saver.save(firstCmd);

        assertThat(System.out.toString().contains("primitive: "));
    }

}

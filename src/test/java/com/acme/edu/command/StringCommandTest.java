package com.acme.edu.command;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCommandTest {

    private StringCommand stateCommand;

    @Before
    public void setUp() throws Exception {
        stateCommand = new StringCommand("abc");
    }

    @Test
    public void shouldAllowFlushWhenAnotherType() {
        //region given
        IntCommand otherCommand = new IntCommand(10);
        //endregion

        //region when
        boolean checkResult = stateCommand.checkFlush(otherCommand);
        //endregion

        //region then
        assertThat(checkResult).isEqualTo(true);
        //endregion
    }

    @Test
    public void shoudNotAllowFlushForSameString() {
        StringCommand otherCommand = new StringCommand("abc");
        boolean checkResult = stateCommand.checkFlush(otherCommand);
        assertThat(checkResult).isFalse();
    }

    @Test
    public void shoudAllowFlushForDifferentString() {
        StringCommand otherCommand = new StringCommand("abcde");
        boolean checkResult = stateCommand.checkFlush(otherCommand);
        assertThat(checkResult).isTrue();
    }

    @Test
    public void shoudDisplayTimesWhenMultipleString() {
        StringCommand otherCommand = new StringCommand("abc");
        String decoratedSelf = stateCommand.getDecoratedSelf();
        assertThat(decoratedSelf).isEqualTo("string: abc");
        stateCommand.accumulate(otherCommand);
        decoratedSelf = stateCommand.getDecoratedSelf();
        assertThat(decoratedSelf).isEqualTo("string: abc (x2)");
    }
}

package com.acme.edu.command;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntCommandTest{

    private IntCommand stateCommand;

    @Before
    public void setUp() throws Exception {
        stateCommand = new IntCommand(1);
    }

    @Test
    public void shouldAllowFlushWhenAnotherType() {
        //region given
        StringCommand otherCommand = new StringCommand("str");
        //endregion

        //region when
        boolean checkResult = stateCommand.checkFlush(otherCommand);
        //endregion

        //region then
        assertThat(checkResult).isEqualTo(true);
        //endregion
    }

    @Test
    public void shouldAllowFlushWhenIntegerOverflow() {
        //region given
        IntCommand otherCommand = new IntCommand(Integer.MAX_VALUE);
        //endregion

        //region when
        boolean checkResult = stateCommand.checkFlush(otherCommand);
        //endregion

        //region then
        assertThat(checkResult).isEqualTo(true);
        //endregion
    }

    @Test
    public void shouldNotAllowFlushWhenNoIntegerOverflow() {
        //region given
        IntCommand otherCommand = new IntCommand(0);
        //endregion

        //region when
        boolean checkResult = stateCommand.checkFlush(otherCommand);
        //endregion

        //region then
        assertThat(checkResult).isEqualTo(false);
        //endregion
    }
}
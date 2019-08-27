package com.acme.edu;

import com.acme.edu.commands.Command;
import com.acme.edu.commands.StringCommand;
import com.acme.edu.commands.CommandAccumulateInfo;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.fest.assertions.Assertions.assertThat;

public class StringCommandTest {
    @Test
    public void shouldAccumulateStrings() {
        final StringCommand sut = new StringCommand("str 1");
        final StringCommand accumulateCommand = new StringCommand("str 1");

        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);

        String decoratedMessage = sut.getDecoratedMessage();

        assertThat(decoratedMessage)
                .isEqualTo("string: str 1 (x2)");
        assertThat(info.isFlushNeeded()).isFalse();

        assertThat(info.getCommand()).isEqualTo(sut);
    }
    @Test
    public void shouldFlushDifferentStrings() {
        final StringCommand sut = new StringCommand("str 1");
        final StringCommand lastCommand = new StringCommand("str prev");

        CommandAccumulateInfo info = sut.accumulate(lastCommand);

        String decoratedMessage = sut.getDecoratedMessage();

        assertThat(decoratedMessage)
                .isEqualTo("string: str 1");
        assertThat(info.getMessage())
                .isEqualTo("string: str prev");

        assertThat(info.getCommand()).isEqualTo(sut);
    }
}

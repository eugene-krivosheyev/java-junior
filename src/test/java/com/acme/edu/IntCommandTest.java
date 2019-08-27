package com.acme.edu;

import com.acme.edu.commands.*;
import org.junit.Test;

import static org.fest.reflect.core.Reflection.*;
import static org.fest.assertions.Assertions.*;

public class IntCommandTest {

    @Test
    public void shouldAccumulateIntegers() {
        final IntCommand sut = new IntCommand(1);
        final IntCommand accumulateCommand = new IntCommand(2);

        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);

        String message = sut.getDecoratedMessage();

        //long message = field("message").ofType(long.class)
          //      .in(IntegerCommand.class).get();


        assertThat(message)
                .isEqualTo("primitive: 3");
        assertThat(info.getMessage()).isNull();

        assertThat(info.getCommand()).isEqualTo(sut);
    }


    @Test
    public void shouldFlushAccumulatedInfoIfUpperOverflow() {
        final ByteCommand sut = new ByteCommand((byte)1);
        final ByteCommand accumulateCommand = new ByteCommand((byte)2);
        final ByteCommand overflowCommand = new ByteCommand((byte)126);


        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);
        CommandAccumulateInfo info1 = overflowCommand.accumulate(sut);

        String message = overflowCommand.getDecoratedMessage();

        //long message = field("message").ofType(long.class)
        //      .in(IntegerCommand.class).get();


        assertThat(info.getMessage()).isNull();
        assertThat(message)
                .isEqualTo("primitive: 126");
        assertThat(info1.getMessage()).isEqualTo("primitive: 3");

        assertThat(info.getCommand()).isEqualTo(sut);
        assertThat(info1.getCommand()).isEqualTo(overflowCommand);
    }


    @Test
    public void shouldFlushAccumulatedInfoIfLowerOverflow() {
        final ByteCommand sut = new ByteCommand((byte)-1);
        final ByteCommand accumulateCommand = new ByteCommand((byte)-2);
        final ByteCommand overflowCommand = new ByteCommand((byte)-128);


        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);
        CommandAccumulateInfo info1 = overflowCommand.accumulate(sut);

        String message = overflowCommand.getDecoratedMessage();

        //long message = field("message").ofType(long.class)
        //      .in(IntegerCommand.class).get();


        assertThat(info.getMessage()).isNull();
        assertThat(message)
                .isEqualTo("primitive: -128");
        assertThat(info1.getMessage()).isEqualTo("primitive: -3");
        assertThat(info.getCommand()).isEqualTo(sut);
        assertThat(info1.getCommand()).isEqualTo(overflowCommand);

    }
}

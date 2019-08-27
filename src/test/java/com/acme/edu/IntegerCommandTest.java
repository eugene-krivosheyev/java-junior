package com.acme.edu;

import com.acme.edu.commands.*;
import org.junit.Test;

import static org.fest.reflect.core.Reflection.*;
import static org.fest.assertions.Assertions.*;

public class IntegerCommandTest {

    @Test
    public void shouldAccumulateIntegersWhenNoOverflow() {
        final IntCommand sut = new IntCommand(1);
        final IntCommand accumulateCommand = new IntCommand(2);

        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);

        String decoratedMessage = sut.getDecoratedMessage();

        assertThat(decoratedMessage).isEqualTo("primitive: 3");
        assertThat(info.isFlushNeeded()).isFalse();

        assertThat(info.getCommand()).isEqualTo(sut);
    }


    @Test
    public void shouldFlushAccumulatedInfoIfUpperOverflow() {
        final ByteCommand sut = new ByteCommand((byte)1);
        final ByteCommand accumulateCommand = new ByteCommand((byte)2);
        final ByteCommand overflowCommand = new ByteCommand((byte)125);


        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);
        CommandAccumulateInfo overflowInfo = overflowCommand.accumulate(sut);

        String message = overflowCommand.getDecoratedMessage();


        assertThat(info.isFlushNeeded()).isFalse();
        assertThat(message).isEqualTo("primitive: 125");
        assertThat(overflowInfo.getMessage()).isEqualTo("primitive: 3");

        assertThat(info.getCommand()).isEqualTo(sut);
        assertThat(overflowInfo.getCommand()).isEqualTo(overflowCommand);
        assertThat(overflowInfo.isFlushNeeded()).isTrue();
    }


    @Test
    public void shouldFlushAccumulatedInfoIfLowerOverflow() {
        final ByteCommand sut = new ByteCommand((byte)-1);
        final ByteCommand accumulateCommand = new ByteCommand((byte)-2);
        final ByteCommand overflowCommand = new ByteCommand((byte)-128);


        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);
        CommandAccumulateInfo overflowInfo = overflowCommand.accumulate(sut);

        String decoratedMessage = overflowCommand.getDecoratedMessage();


        assertThat(info.isFlushNeeded()).isFalse();
        assertThat(decoratedMessage).isEqualTo("primitive: -128");
        assertThat(overflowInfo.getMessage()).isEqualTo("primitive: -3");

        assertThat(info.getCommand()).isEqualTo(sut);
        assertThat(overflowInfo.getCommand()).isEqualTo(overflowCommand);
        assertThat(overflowInfo.isFlushNeeded()).isTrue();

    }





    @Test
    public void shouldNotFlushAccumulatedInfoOnUpperBoundaryValue() {
        final ByteCommand sut = new ByteCommand((byte)1);
        final ByteCommand accumulateCommand = new ByteCommand((byte)2);
        final ByteCommand notOverflowCommand = new ByteCommand((byte)124);


        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);
        CommandAccumulateInfo notOverflowInfo = notOverflowCommand.accumulate(sut);

        String message = notOverflowCommand.getDecoratedMessage();


        assertThat(info.isFlushNeeded()).isFalse();
        assertThat(message).isEqualTo("primitive: 127");

        assertThat(info.isFlushNeeded()).isFalse();
        assertThat(info.getCommand()).isEqualTo(sut);
        assertThat(notOverflowInfo.getCommand()).isEqualTo(notOverflowCommand);
    }


    @Test
    public void shouldNotFlushAccumulatedInfoOnLowerBoundaryValue() {
        final ByteCommand sut = new ByteCommand((byte)-1);
        final ByteCommand accumulateCommand = new ByteCommand((byte)-2);
        final ByteCommand notOverflowCommand = new ByteCommand((byte)-125);

        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);
        CommandAccumulateInfo notOverflowInfo = notOverflowCommand.accumulate(sut);

        String message = notOverflowCommand.getDecoratedMessage();


        assertThat(info.isFlushNeeded()).isFalse();
        assertThat(message).isEqualTo("primitive: -128");

        assertThat(info.isFlushNeeded()).isFalse();
        assertThat(info.getCommand()).isEqualTo(sut);
        assertThat(notOverflowInfo.getCommand()).isEqualTo(notOverflowCommand);
    }

    @Test
    public void ifOtherIsNullThenReturnCurrentCommand() {
        final IntCommand sut = new IntCommand(1);
        final IntCommand nullComand = null;

        CommandAccumulateInfo accumulateInfo = sut.accumulate(nullComand);

        assertThat(accumulateInfo.getCommand()).isEqualTo(sut);
        //TODO
    }
}

package com.acme.edu;

import com.acme.edu.commands.*;
import com.acme.edu.commands.Integer.ByteCommand;
import com.acme.edu.commands.Integer.IntCommand;
import com.acme.edu.commands.Integer.IntegerOverflowException;
import org.junit.Test;

import static org.fest.assertions.Assertions.*;

public class IntegerCommandTest {

    @Test
    public void shouldAccumulateIntegersWhenNoOverflow() {
        final IntCommand sut = new IntCommand(1);
        final IntCommand accumulateCommand = new IntCommand(2);

        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);

        String decoratedMessage = info.getCommand().getDecoratedMessage();

        assertThat(decoratedMessage).isEqualTo("primitive: 3");
        assertThat(info.isFlushNeeded()).isFalse();

    }


    @Test(expected = IntegerOverflowException.class)
    public void shouldRaiseExceptionWhenUpperOverflow() {
        final ByteCommand sut = new ByteCommand((byte)1);
        final ByteCommand accumulateCommand = new ByteCommand((byte)2);
        final ByteCommand overflowCommand = new ByteCommand((byte)125);


        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);
        CommandAccumulateInfo overflowInfo = overflowCommand.accumulate(info.getCommand());

        String message = overflowInfo.getCommand().getDecoratedMessage();


        assertThat(info.isFlushNeeded()).isFalse();
        assertThat(message).isEqualTo("primitive: 125");
        assertThat(overflowInfo.getMessage()).isEqualTo("primitive: 3");

        assertThat(overflowInfo.getCommand()).isEqualTo(overflowCommand);
        assertThat(overflowInfo.isFlushNeeded()).isTrue();
    }


    @Test(expected = IntegerOverflowException.class)
    public void shouldRaiseExceptionWhenULoverOverflow() {
        final ByteCommand sut = new ByteCommand((byte)-1);
        final ByteCommand accumulateCommand = new ByteCommand((byte)-2);
        final ByteCommand overflowCommand = new ByteCommand((byte)-128);


        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);
        CommandAccumulateInfo overflowInfo = overflowCommand.accumulate(sut);

        String decoratedMessage = overflowCommand.getDecoratedMessage();


        assertThat(info.isFlushNeeded()).isFalse();
        assertThat(decoratedMessage).isEqualTo("primitive: -128");
        assertThat(overflowInfo.getMessage()).isEqualTo("primitive: -3");

        assertThat(overflowInfo.getCommand()).isEqualTo(overflowCommand);
        assertThat(overflowInfo.isFlushNeeded()).isTrue();

    }





    @Test
    public void shouldNotFlushAccumulatedInfoOnUpperBoundaryValue() {
        final ByteCommand sut = new ByteCommand((byte)1);
        final ByteCommand accumulateCommand = new ByteCommand((byte)2);
        final ByteCommand notOverflowCommand = new ByteCommand((byte)124);


        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);
        CommandAccumulateInfo notOverflowInfo = notOverflowCommand.accumulate(info.getCommand());

        String message = notOverflowInfo.getCommand().getDecoratedMessage();


        assertThat(info.isFlushNeeded()).isFalse();
        assertThat(message).isEqualTo("primitive: 127");

        assertThat(info.isFlushNeeded()).isFalse();

    }


    @Test
    public void shouldNotFlushAccumulatedInfoOnLowerBoundaryValue() {
        final ByteCommand sut = new ByteCommand((byte)-1);
        final ByteCommand accumulateCommand = new ByteCommand((byte)-2);
        final ByteCommand notOverflowCommand = new ByteCommand((byte)-125);

        CommandAccumulateInfo info = sut.accumulate(accumulateCommand);
        CommandAccumulateInfo notOverflowInfo = notOverflowCommand.accumulate(info.getCommand());

        String message = notOverflowInfo.getCommand().getDecoratedMessage();


        assertThat(info.isFlushNeeded()).isFalse();
        assertThat(message).isEqualTo("primitive: -128");

        assertThat(info.isFlushNeeded()).isFalse();

    }

    @Test
    public void ifOtherIsNullThenReturnCurrentCommand() {
        final IntCommand sut = new IntCommand(1);
        final IntCommand nullComand = null;

        CommandAccumulateInfo accumulateInfo = sut.accumulate(nullComand);

        assertThat(accumulateInfo.isFlushNeeded()).isFalse();
        assertThat(accumulateInfo.getMessage()).isNull();
    }


    @Test
    public void ifOtherIsAnotherIntegerTypeThenFlushIsNeeded() {
        final ByteCommand firstCommand = new ByteCommand((byte)1);
        final IntCommand sut = new IntCommand(2);

        CommandAccumulateInfo accumulateInfo = sut.accumulate(firstCommand);

        assertThat(accumulateInfo.getCommand()).isEqualTo(sut);
        assertThat(accumulateInfo.isFlushNeeded()).isTrue();
        assertThat(accumulateInfo.getMessage()).isEqualTo("primitive: 1");
    }



    @Test
    public void ifGetAnotherCommandTypeThenFlushIsNeeded() {
        final IntCommand sut = new IntCommand(1);
        final StringCommand anotherCommand = new StringCommand("str: 1");

        CommandAccumulateInfo accumulateInfo = sut.accumulate(anotherCommand);

        assertThat(accumulateInfo.isFlushNeeded()).isTrue();
        assertThat(accumulateInfo.getMessage()).contains("str: 1");
    }
}

package com.acme.edu.ooaddemo2;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class IntCommandTest {
    @Test //BDD = DDD(tests) = docum = reqs.
    public void shouldAccumulateWithSameCommand() {
        final IntCommand sut = new IntCommand(1, 0);
        final IntCommand accumulateResult = sut.accumulate(sut);
        assertThat(accumulateResult.getMessage())
                .isEqualTo(2);
    }
}

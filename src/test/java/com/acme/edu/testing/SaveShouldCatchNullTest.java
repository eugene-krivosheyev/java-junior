package com.acme.edu.testing;

import com.acme.edu.saver.ConsoleSaver;
import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;
import org.junit.Test;


public class SaveShouldCatchNullTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenTheArgumentIsNull() throws Exception {
        ConsoleSaver consoleSaver = new ConsoleSaver();
        consoleSaver.save(null);
    }
}

package com.acme.edu.saver;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsoleSaverTest {
    @Test
    public void shouldNotifyWhenReceiveNull() {
        ConsoleSaver saver = new ConsoleSaver();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> saver.save(null));
        assertThat(thrown).hasMessage("String argument is null");
    }
}

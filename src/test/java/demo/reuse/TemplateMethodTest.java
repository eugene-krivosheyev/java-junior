package demo.reuse;

import org.junit.Test;

import java.sql.Connection;

public class TemplateMethodTest {
    @Test
    public void shouldUseTemplateAndSubstituteStep() {
        final TemplateMethod sut = new StepImplementation2();
        sut.log();
    }
}

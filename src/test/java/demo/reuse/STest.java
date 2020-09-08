package demo.reuse;

import org.junit.Test;

public class STest {
    @Test
    public void shouldUseTemplateAndSubstituteStep() {
        final Subject sut = new Subject(new StrategyImpl1());
        sut.log();
    }
}

import org.junit.Before;
import org.junit.Test;
import simpleLogger.*;

import java.io.IOException;

public class simpleLoggerTest implements SysoutCaptureAndAssertionAbility{
    private SimpleFilter simpleFilter;
    private SimpleLoggerSaver simpleLoggerSaver;
    private SimpleLogger simpleLogger;

    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @Test
    public void lengthFilterTest() {
        int filterLength = 12;
        simpleFilter = new SimpleFilterLength(filterLength);
        assert simpleFilter.filter("");
        assert simpleFilter.filter("test");
        assert !simpleFilter.filter("123456789012");
        assert !simpleFilter.filter("asdfghjkl;'qwertyuiui");
    }

    @Test
    public void loggingLevelTest() {
        simpleFilter = new SimpleFilterloggingLevel(LogLevel.DEBUG);
        assert simpleFilter.filter("[DEBUG] test message");
        assert simpleFilter.filter("[INFO] test message");
        assert simpleFilter.filter("[AAA] test message");

        simpleFilter = new SimpleFilterloggingLevel(LogLevel.INFO);
        assert !simpleFilter.filter("[DEBUG] test message");
        assert simpleFilter.filter("[INFO] test message");
        assert !simpleFilter.filter("[AAA] test message");

        simpleFilter = new SimpleFilterloggingLevel(LogLevel.WARN);
        assert !simpleFilter.filter("[DEBUG] test message");
        assert simpleFilter.filter("[INFO] test message");
        assert !simpleFilter.filter("[AAA] test message");

    }

    @Test
    public void consoleSaver() {
        simpleLoggerSaver = new SimpleLoggerSaverConsole();
        simpleLoggerSaver.save("TESTS");
        assertSysoutContains("TESTS");
    }

    @Test
    public void logTest(){
        simpleLogger = new SimpleLogger(new SimpleFilterLength(6), new SimpleLoggerSaverConsole());
        simpleLogger.log("TETSTSTSTSTTS");
        simpleLogger.log("12345");
        simpleLogger.log("TETSTSTSTSTTS");
        assertSysoutContains("12345");

        simpleLogger.log("TETSTSTSTSTTS");
        simpleLogger.log("TETSTSTSTSTTS");
        assertSysoutContains("");
    }

    @Test
    public void logTestlogLevelFilter(){
        simpleLogger = new SimpleLogger(new SimpleFilterloggingLevel(LogLevel.DEBUG), new SimpleLoggerSaverConsole());
        simpleLogger.log("TETSTSTSTSTTS");
        simpleLogger.log("12345");
        simpleLogger.log("TETSTSTSTSTTS");
        assertSysoutContains("TETSTSTSTSTTS" + System.lineSeparator() +
                "12345" + System.lineSeparator() +
                "TETSTSTSTSTTS");

        simpleLogger.log("TETSTSTSTSTTS");
        simpleLogger.log("TETSTSTSTSTTS");
        assertSysoutContains("TETSTSTSTSTTS" + System.lineSeparator() +
                "TETSTSTSTSTTS" + System.lineSeparator());
    }
}

package demo.ooad;

import demo.ooad.Logger;
import org.junit.Test;

public class LoggerTest {
    @Test
    public void shouldLog() {
        Logger logger = new Logger();
        logger.log(new LoggerMessage("AAAAA!!", 0));
    }
}

package demo.ooad;

import org.junit.Test;

public class LoggerTest {
    @Test
    public void shouldLog() {
        //logger.setSaver(new FileLoggerSaver(""));
        //logger.saver = new FileLoggerSaver("");

        Logger logger = new Logger(new FileLoggerSaver("filename"));
        logger.log(new LoggerMessage("AAAAA!!", 0));
    }
}

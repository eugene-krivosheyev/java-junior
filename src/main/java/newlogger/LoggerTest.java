package newlogger;

import newlogger.facade.Logger;

public class LoggerTest {
    public static void main(String[] args) {
        Logger.log(0);
        Logger.log((byte)1);
        Logger.log("2");
        Logger.flush();
    }
}

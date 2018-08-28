package newlogger;

import newlogger.message.Logger;

public class LoggerTest {
    public static void main(String[] args) {
        Logger.log(null);
        Logger.log((byte)1);
        Logger.log("2");
        Logger.flush();
    }
}

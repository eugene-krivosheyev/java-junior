package com.db.ooad;


public class App {
    public static void main(String[] args) {
        Logger logger = new Logger(
                new ContentSeverityFilter(MsgSeverity.DEBUG),
                new ConsoleSaver());
        logger.log("[ERROR] Hello");
        logger.log("[INFO] Info");
        logger.log("[DEBUG] Debug");
    }
}

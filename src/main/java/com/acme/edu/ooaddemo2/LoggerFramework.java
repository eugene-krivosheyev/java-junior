package com.acme.edu.ooaddemo2;

public class LoggerFramework {
    public static void main(String[] args) {
        //1. Build
        final LoggerController logger = new LoggerController(
                        new SuperSeverityFilter(5),
                        new SuperConsoleSaver()
        );

        //2. Handle Reqs
        logger.log(new Command("kgjhdkgjhdfkg", 5));
    }
}

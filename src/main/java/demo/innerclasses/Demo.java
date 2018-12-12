package demo.innerclasses;

import demo.ooad.Logger;
import demo.ooad.LoggerFilter;

public class Demo {
    private static int classState;
    private int instanceState;

    public static void main(String[] args) {
        int tempVar = 0;

        Logger logger = new Logger(new LoggerFilter() {
            @Override
            public boolean filter(String message, int severity) {
                System.out.println(tempVar);
                return false;
            }
        });
    }
}
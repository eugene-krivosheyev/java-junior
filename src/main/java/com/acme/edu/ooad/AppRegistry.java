package com.acme.edu.ooad;

public class AppRegistry {
    public static SaverFactory getSaverFactory() {
        return new HardCodedSaverFactory();
    }
}

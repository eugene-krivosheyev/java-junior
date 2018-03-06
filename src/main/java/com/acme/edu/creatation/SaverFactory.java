package com.acme.edu.creatation;

public class SaverFactory {
    public static Saver create() {
        return new ConsoleSaver();
    }
}

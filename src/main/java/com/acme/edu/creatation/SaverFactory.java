package com.acme.edu.creatation;

public class SaverFactory {
    /**
     * [GoF] Factory Method:
     * Parameter FM
     * Configurable FM
     */
    public static Saver create() {
        return new ConsoleSaver();
    }
}

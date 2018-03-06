package com.acme.edu.creatation;

public class SaverXMLConfigFactory implements SaverAbstractFactory {
    @Override
    public Saver create() {
        return new ConsoleSaver();
    }
}

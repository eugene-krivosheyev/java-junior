package com.acme.edu.creatation;

public class LoggerController {
    private final SaverAbstractFactory configFactory = new SaverXMLConfigFactory(); //-> Factory of Factories -> Registry
    Saver saver = configFactory.create(); //Abstract Factory [GoF]

}

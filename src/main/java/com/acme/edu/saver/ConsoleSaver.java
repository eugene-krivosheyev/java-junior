package com.acme.edu.saver;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class ConsoleSaver extends Saver {

    @Override
    public  void save(String decoratedMessage) throws SaveException {
        if (!super.checkIsNull(decoratedMessage)) {
            System.out.println(decoratedMessage);
        }
    }
}
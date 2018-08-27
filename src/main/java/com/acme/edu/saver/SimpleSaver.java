package com.acme.edu.saver;

/**
 * Created by Java_1 on 24.08.2018.
 */
public class SimpleSaver extends Saver {

    public  void save(String decoratedMessage) {
        if (!super.checkIsNull(decoratedMessage)) {
            System.out.println(decoratedMessage);
        }
    }
}
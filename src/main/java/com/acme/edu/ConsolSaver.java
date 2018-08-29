package com.acme.edu;

/**
 * Created by Java_12 on 27.08.2018.
 */
public class ConsolSaver extends ParameterCheckingSaver {
    public void save(String decoratedString) {
        super.save(decoratedString);
        System.out.println(decoratedString);
    }
}

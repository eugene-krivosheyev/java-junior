package com.acme.edu;

import java.io.IOException;

/**
 * Created by Java_12 on 27.08.2018.
 */
public class ConsoleSaver extends ParameterCheckingSaver {
    public void save(String decoratedString) throws LogException {
        super.save(decoratedString);
        System.out.println(decoratedString);
    }
}

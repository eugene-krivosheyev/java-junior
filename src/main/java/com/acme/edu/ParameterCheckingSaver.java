package com.acme.edu;

import java.io.IOException;

public class ParameterCheckingSaver implements Saver {
    @Override
    public void save(String decoratedString) {
        if (decoratedString == null) {
            System.out.println("It is null!!!!");
        };
    }
}

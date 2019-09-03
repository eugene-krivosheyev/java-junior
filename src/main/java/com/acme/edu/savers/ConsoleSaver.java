package com.acme.edu.savers;

import java.io.IOException;

/**
 * Created by kate-c on 21/08/2019.
 */
public class ConsoleSaver implements Saver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }

}

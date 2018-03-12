package com.acme.edu.generic;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenericsDemo {
    public static void main(String[] args) {
        GenericSaver<FileInputStream, Integer> saver;

        GenericSaver.<String, Integer>getMaxElement(3);

        List<? extends RuntimeException> list = new ArrayList<>();
        list.get(0).printStackTrace();

        Collections.sort(null);
        List<String> l = new ArrayList<String>();

    }
}

class GenericSaver<T extends Closeable, U> {
    private U state;

    public void save(T element) {
        try {
            element.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T get(U param) {
        return null;
    }

    public static <V extends String, W> V getMaxElement(W p) {
        return null;
    }
}

interface Saveable<T> {
    void save(T toSave);
}

class DBSaver1 implements Saveable {
    @Override
    public void save(Object toSave) {

    }
}

class DBSaver2<T> implements Saveable<T> {
    @Override
    public void save(T toSave) {

    }
}

class DBSaver3 implements Saveable<String> {
    @Override
    public void save(String toSave) {

    }
}




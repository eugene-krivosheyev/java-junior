package com.acme.edu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * http://www.angelikalanger.com/GenericsFAQ/JavaGenericsFAQ.html
 */
public class GenericsDemo {
    public static void main(String[] args) {
        GenericAlgorithm algo = new GenericAlgorithm();
        Object object = algo.m("");
        if (object instanceof String) {
            String stringObject = (String) object;
            stringObject.toUpperCase();
        }

        GenericAlgorithm<String> typedAlgo =
                new GenericAlgorithm<>();
        String result = typedAlgo.m("");

        String sm = GenericAlgorithm.<String>sm();

        List<? super String> list =
                new ArrayList<String>();
    }
}

class GenericAlgorithm<T extends String> {
    private T field;

    public T m(T p) {
        return null;
    }


    public static <U> U sm() {
        return null;
    }
}

interface Saver<T> {
    T save(T objectToSave);
}

class Saver1<T> implements Saver<T> {
    @Override
    public T save(T objectToSave) {
        return null; //new T();
    }
}

class StringSaver implements Saver<String> {
    @Override
    public String save(String objectToSave) {
        return null;
    }
}

class Saver3<T> implements Saver {
    @Override
    public T save(Object objectToSave) {
        return null;
    }
}
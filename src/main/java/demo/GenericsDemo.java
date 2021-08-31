package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenericsDemo {
    public static void main(String[] args) {
        List list = new ArrayList(); //DI, factory,.....
        list.add("abc");

        Object o = list.get(0);
        if (o instanceof String) {
            String e = (String) o; // ~~ClassCastException~~
        }


        List<? extends Number> li = new ArrayList<Integer>();
        li.get(0);

        List<Integer> ls = new ArrayList<>(); //diamond operator
        Collections.sort(ls, Integer::compareTo);

        m("");
        GenericsDemo.<String>m();
    }

    private static <U> U m(U param) {
        return null;
    }

    private static <V> V m() {
        return null;
    }
}

/**
 * 1. универсальный алгоритм для любых типов
 * 2. строгую типизацию хочу
 */
class Structure<T> {
    private T value;
    public T getValue() {
        return value;
    }
}

interface Storageable<Z> {
    Z getObject(Z param);
}

class S1 implements Storageable {
    @Override
    public Object getObject(Object param) {
        return null;
    }
}

class S2<Z> implements Storageable<Z> {
    @Override
    public Z getObject(Z param) {
        return null;
    }
}

class S3 implements Storageable<String> {
    @Override
    public String getObject(String param) {
        return null;
    }
}

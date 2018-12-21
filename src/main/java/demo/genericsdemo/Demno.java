package demo.genericsdemo;

import java.util.ArrayList;

import static demo.genericsdemo.MySuperComparator.compareTo;

public class Demno {
    public static void main(String[] args) {
        String s = compareTo("", "");
        Integer m = MySuperComparator.<Integer>m();

//        MySuperComparator<Object> comp =
//                new MySuperComparator<String>();
//
        ArrayList<String> c = new ArrayList<>();


    }
}

interface SuperPuperComparator<T> {
    int compareTo(T o1, T o2);
}

class SPC1 implements SuperPuperComparator<String> {
    @Override
    public int compareTo(String o1, String o2) {
        return 0;
    }
}

class SPC2<T extends String> implements SuperPuperComparator<T> {
    @Override
    public int compareTo(T o1, T o2) {
        o1.toUpperCase();
//        Collections.sort(new ArrayList<>());
        return 0;
    }
}

class SPC3 implements SuperPuperComparator {
    @Override
    public int compareTo(Object o1, Object o2) {
        return 0;
    }
}




class MySuperComparator<V> {
    private V field;

    public V getField() {
        return field;
    }

    public void setField(V field) {
        this.field = field;
    }

    public static<T> T compareTo(T o1, T o2) {
        T object;
        return null;
    }

    public static<U> U m() {
        return null;
    }
}

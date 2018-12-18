package demo.genericsdemo;

import static demo.genericsdemo.MySuperComparator.compareTo;

public class Demno {
    public static void main(String[] args) {
        String s = compareTo("", "");
        Integer m = MySuperComparator.<Integer>m();

        MySuperComparator<Object> comp
                = new MySuperComparator<String>();
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

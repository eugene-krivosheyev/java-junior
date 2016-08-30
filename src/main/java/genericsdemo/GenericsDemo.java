package genericsdemo;


import demo.Saver;

import java.util.*;

public class GenericsDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String s = Decorator.<String, String>decorate("", String.class);

        Decorator<? extends Object> d = new Decorator<String>();

        Collection<String> c = new ArrayList<>();
        c.add("");

        MyGenericComparator<String> y;
        MyGenericComparator<Byte> z;

        MyIntegerComparator a;

        Collections.sort(
            Arrays.asList(1, 2, 3),
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return 0;
                }
            }
        );
    }
}

class MyGenericComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return 0;
    }
}

class MyIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}

class Decorator<U extends Object> {
    private U field;

    public U getField() {
        return field;
    }

    public void setField(U field) {
        this.field = field;
    }


    public static <T extends Object, P> P decorate(T message, Class<T> typeInfo) {
        //!!!!! new T();
        return null;
    }
}

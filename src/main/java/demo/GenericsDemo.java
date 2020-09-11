package demo;

import refactoring.message.IntMessage;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;

@SuppressWarnings("rawtypes")
public class GenericsDemo {
    public static void main(String[] args) {
        final Object subject = new Optional("").of(1);
        if (subject instanceof String) {
            final String stringSubject = (String) subject; //ClassCastException!!!
        }

        Optional<String,String> maybe = new Optional<String,String>("some string");
        maybe.getIfNotEmpty().toUpperCase();

        Optional.of("").toUpperCase();
        GenericsDemo.<String>create().toUpperCase();

        List<String> stringList = new LinkedList<>();
        stringList.get(0).toUpperCase();



        List<Object> list = null; // new LinkedList<String>(); //Java7 -> <>
        list.add(1);
        list.get(0).toString();//Object's mthods only!!!

        List<? extends Object> stringList1 = new ArrayList<Object>();
        List<? super String> stringList3 = new ArrayList<String>();

        final List<Integer> integers = asList(1, 2, 3, 4, 5, 6);
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        integers.sort(reverseOrder());
    }

    public static <V> V create() {
        return null;
    }
}

class Optional<T,Z> {
    private T subject;
    private static final Optional EMPTY = new Optional(null);

    public static <U> U of(U subject) {
        return null; //new U();
    }

    public Optional(T subject) {
        this.subject = subject;
    }

    public T getIfNotEmpty() {
        return subject;
    }
}


interface Saver<S> {
    void save(S saveable);
}

class SaverImpl1 implements Saver {
    @Override
    public void save(Object saveable) {

    }
}

class SaverImpl2 implements Saver<String> {
    @Override
    public void save(String saveable) {

    }
}

class SaverImpl3<W,Q> implements Saver<W> {
    @Override
    public void save(W saveable) {

    }
}

package demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class GenericsDemo {
    public static void main(String[] args) {
//        final Queue queue = new Queue();
//        queue.add("1");
//        queue.add("2");
//
//        final Object element = queue.get();
//        if (element instanceof String) {
//            final var typedElement = (String) element;
//        }
//
//        Queue<Number> queueOfNumbers = new Queue<Number>(1);
//        queueOfNumbers.add(new BigDecimal(1));
//
//        Queue.<Integer>m();
//
//        Collection<String> coll = ;
    }
}


class Queue<T extends Number> {
    private T element;

    public Queue(T element) {
        this.element = element;
    }

    public void add(T element) {

    }

    public T get() {
        return null;
    }

    public static <U extends Number> U m() {
        return null;
    }
}

interface I<V> {
    V m();
}

@SuppressWarnings("rawtypes")
class I1 implements I {
    @Override
    public Object m() {
        return null;
    }
}

class I2<V> implements I<V> {
    @Override
    public V m() {
        return null;
    }
}

class I3 implements I<String> {
    @Override
    public String m() {
        return null;
    }
}

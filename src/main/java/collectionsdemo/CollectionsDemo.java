package collectionsdemo;

import java.util.*;
import java.util.function.Consumer;

public class CollectionsDemo {
    public static void main(String[] args) {
        Maybe<String> boxedValue =
                Maybe.<String>empty();
        boxedValue.get();
        /*
        if (unboxedValue instanceof Integer) {
            (Integer)unboxedValue;
        }
        */

        ArrayList<? extends Object> cats = new ArrayList<String>();

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Collections.sort(numbers, (o1, o2) -> 0);
    }

}

class Maybe<T> {
    private T maybeObject;

    public Maybe(T toWrap) {
        this.maybeObject = toWrap;
    }

    public static <U> Maybe<U> of(U toWrap) {
        return new Maybe<>(toWrap);
    }

    public static <V> Maybe<V> empty() {
        return new Maybe<>(null);
    }

    public T get() {
        return maybeObject;
    }

    public boolean isPresent() {
        return maybeObject != null;
    }

    public void ifPresent(Consumer todo) {
        if (maybeObject != null) {
            todo.accept(maybeObject);
        }
    }
}

interface MyComparator<T> {
    void compareTo(T t1, T t2);
}

class MyComporatorImpl1<T extends String> implements MyComparator<T> {
    @Override
    public void compareTo(T t1, T t2) {

    }
}

/*
class MyComporatorImpl2<String> implements MyComparator<T> {
    @Override
    public void compareTo(T t1, T t2) {

    }
}
*/

class MyComporatorImpl3 implements MyComparator<String> {
    @Override
    public void compareTo(String t1, String t2) {

    }
}

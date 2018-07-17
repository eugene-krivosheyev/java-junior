package demo.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;

public class Demo {
    public static void main(String[] args) {
        MySuperArray<String> array = new MySuperArray<>(new String[5]);
        array.setElement("abc", 1);

        //===========

//        doIfString(
//                array.getElement(1),
//                System.out::println
//        );

        //when(myObj.toString()).thenReturn("");
    }

//    public static void doIfString(Object element, ToDo todo) {
//        if (element instanceof String) {
//            todo.<String>todo();
//        }
//    }
}

interface ToDo {
    <T> T todo(T param);
}

/**
 * Generic Algorithm
 */
class MySuperArray<E> {
    private E[] internalArray;

    MySuperArray(E[] internalArray) {
        this.internalArray = internalArray;
    }

    public void setElement(E newValue, int position) {
        this.internalArray[position] = newValue;
    }

    public E getElement(int position) {
        return this.internalArray[position];
    }
}

interface Interf<T> {
    T operation();
}

class Sub1<T> implements Interf<T> {
    @Override
    public T operation() {
        return null;
    }
}

class Sub2 implements Interf<String> {
    @Override
    public String operation() {
        return null;
    }
}
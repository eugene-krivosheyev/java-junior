package demo.generics;

import java.util.function.Consumer;

public class Demo {
    public static void main(String[] args) {
        MySuperArray array = new MySuperArray();
        array.setElement("abc", 1);

        //===========

        doIfString(
                array.getElement(1),
                System.out::println
        );
    }

    public static void doIfString(Object element, Consumer todo) {
        if (element instanceof String) {
            todo.accept((String)element);
        }
    }
}

interface ToDo {
    void todo(Object subject);
}

/**
 * Generic Algorithm
 */
class MySuperArray {
    private Object[] internalArray = new Object[15];

    public void setElement(Object newValue, int position) {
        this.internalArray[position] = newValue;
    }

    public Object getElement(int position) {
        return this.internalArray[position];
    }
}

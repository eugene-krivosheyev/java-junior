package demo.polymorphism;

public class Demo {
    public static void main(String[] args) {
        Object[] array = new Object[10];
        array[0] = "11";
        array[1] = new Integer(22);

        //===

        String s; //Class Cast Excp!
        if (array[0] instanceof String) { //or reflect
            s = (String) array[0];
        }

    }


}

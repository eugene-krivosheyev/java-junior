package demo;

import java.util.Objects;

public class StringDemo {
    public static void main(String[] args) {
        String string1 = "A";
        String string2 = "A";

        //interning
        System.out.println(
            Objects.equals(string1, string2)
        );

        System.out.println("aa".toUpperCase());

        System.out.println("a" + "b" + "c");
        //Fluent API, Fluent interface
        new StringBuilder("a").append("b").append("c");

        StringBuilder sbb = new StringBuilder("a");
        StringBuffer sbf;
    }
}

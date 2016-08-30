package syslibdemo;

import java.util.Objects;

public class Human implements Cloneable {
    private String name;
    private int age;

    @Override
    public Human clone() throws CloneNotSupportedException {
        return (Human)super.clone();
    }

    public static void main(String[] args) {
        Integer b1 = 128;
        Integer b2 = 128;

        System.out.println(b1 == b2);
    }
}

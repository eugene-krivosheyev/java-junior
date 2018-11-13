package demo;

import java.util.Objects;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "abc"; //new() + intern()
        String s2 = "abc"; // s2 -> s1

        System.out.println(s1.toUpperCase()); //StringBuffer, StringBuilder

        System.out.println(s1.equals(s2));
        System.out.println(Objects.equals(s1, s2));

        System.out.println(s1.equals("abc"));
        System.out.println("abc".equals(s1));
    }
}

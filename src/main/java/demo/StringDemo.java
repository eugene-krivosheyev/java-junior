package demo;

import java.util.Objects;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "abc"; //new() + intern()
        String s2 = "abc"; // s2 -> s1

        String longString = "aaaaaaaa";
        String internedString = longString.intern();

        System.out.println(s1.toUpperCase()); //StringBuffer, StringBuilder

        System.out.println(s1.equals(s2));
        System.out.println(Objects.equals(s1, s2));

        System.out.println(s1.equals("abc"));
        System.out.println("abc".equals(s1));

        System.out.println(1 + 2 + "3" + 4 + 5); //3345

        System.out.println("a" + "b" + "c" + "d" + "e");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder //Fluent API | interface
            .append("a")
            .append("b")
            .append("c")
            .append("d")
            .append("e");
        stringBuilder.toString();
    }
}

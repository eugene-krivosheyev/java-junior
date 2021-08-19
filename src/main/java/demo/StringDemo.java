package demo;

import java.util.Locale;
import java.util.Objects;

public class StringDemo {
    private int i;

    public static void main(String[] args) {
        String str0 = new String("abc");
        String str1 = new String("abc");
        String str2 = "abc"; //new String("abc") + .intern()
        String str3 = "abc";
        System.out.println( str2 == str3  );

        String str3upped = str3.toUpperCase();
        System.out.println(str3);
        System.out.println(str3upped);

        StringBuffer sb1 = new StringBuffer("1"); // vs String
        StringBuilder sb2;

        Integer integer = new Integer(5); // auto boxing + intern()
        int i = integer.intValue(); //auto unboxing

        Integer integer1 = 128;
        Integer integer2 = 128; //-----new Integer()-----
        System.out.println( integer1 == integer2 );

        str1.equals(str2);
        Objects.equals(integer1, integer2);

        if (str1.equals("abc")) {

        }

        if ("abc".equals(str1)) {

        }
    }


}

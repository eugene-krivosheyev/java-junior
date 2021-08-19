package demo;

import java.util.Locale;

public class StringDemo {
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
        System.out.println("1" + ? + "3" + ? + "5");
        sb1.append("2").append(?).append("3").append(?).append("5");
    }
}

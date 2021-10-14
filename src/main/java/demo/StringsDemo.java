package demo;

import java.util.Objects;

public class StringsDemo {
    public static void main(String[] args) {
        //region String interning
        String str1 = "abc"; // new String() + intern()
        String str2 = "abc";

        str1 = str1.toUpperCase();
        System.out.println(str1); //ABC

        System.out.println("a" + "b" + "c" + "d");
        StringBuilder stringBuilder = new StringBuilder("a")
                .append("b")
                .append("c")
                .append("d");
        StringBuffer stringBuffer;
        //endregion

        //region Wrappers
        Integer i1 = 128; //auto boxing  + interning
        Integer i2 = 128;

        System.out.println( i1 == i2 );

        int ii = i1; //auto unboxing
        //endregion
    }
}

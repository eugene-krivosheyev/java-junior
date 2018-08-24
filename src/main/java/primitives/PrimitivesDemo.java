package primitives;

import java.util.Objects;

public class PrimitivesDemo {
    public static void main(String[] args) {
        //region Целочисленные
        byte b = -0b1001; //signed
        short s = Short.MAX_VALUE;
        int i = 10_000_000;
        long l = 9999999999L;
        //endregion

        //region Действительные
        float f = -2e-3F; //32bit
        double d = 0.0; //64bit
        //endregion

        //region Символьный
        char c = '㌳'; //'\u3333';
        int charNumber = c;
        System.out.println(charNumber);
        //endregion

        //region Логический
        boolean boo = true | false;
        //#DEFINE true false
        //endregion

        //region Строковый тип
        //DP: Immutable
        String str1 = new String("a"); str1.intern();
        String str2 = "a"; //new String() + intern()
        System.out.println(str1 == str2);
        System.out.println(">: " + (null == null));

        System.out.println(str1.equals(str2)); //NPE!!!
        Objects.equals(str1, str2);

        String newString = str1.toUpperCase();
        System.out.println(newString);

//        StringBuffer, StringBuilder;
        System.out.println("a" + "b" + "c" + "d" + "e");
        StringBuilder sb = new StringBuilder("a");
        sb.append("b").append("c").append("d"); //Fluent Interface
        //endregion
    }
}

package primitives;

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

        //region Ссылочный тип
        String str = "";
        //endregion
    }
}

package demo;

public class PrimitivesDemo {
    public static void main(String[] args) {
        //region Целые
        byte b = 07; //0b100
        short s = 1_000;
        int i = 0xDEADCAFE;
        long l = 999999999999999999L;
        //Byte.MAX_VALUE
        //endregion

        //region Дробные
        float f = .0F; //32 bit
        double d = 2.1e3; //64 bit
        //Float.MAX_VALUE
        //endregion

        //region Логический
        boolean bb = true; //false
        //bb = (boolean) 5;
        //endregion

        //region Символьный
        char c = 'ざ'; //int charCode = c;
        System.out.println( (char)0xABCD );
        System.out.println('\n');
        //endregion


        //region Приведение типов
        //region Arithmetic promotions
        byte b1 = 1, b2 = 2;
        int byteResult = b1 + b2;
        long intLongResult = 1 + 1L;
        //endregion
        //region Auto casting, неявное приведение
        short shortResult = b1;
        //endregion
        //region Явное приведение
        int smallIntValue = Byte.MAX_VALUE + 1;
        byte smallByteValue = (byte) smallIntValue;
        System.out.println(smallByteValue);
        //endregion
        //endregion
    }
}

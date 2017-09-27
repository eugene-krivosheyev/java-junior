package demo;

public strictfp class PrimitivesDemo {
    public strictfp static void main(String[] args) {
        //region Целые со знаком
        byte b = 1_00; //1 byte, Byte.MAX_VALUE
        short s = 010; //2 byte
        int i = 0x10; //4 bytes
        long l = 10000000000000L; //8 byte
        //endregion

        //region С плавающей точкой
        float f = 0.0000000000000000000000000000000000000001f; //16 byte, IEEE 754?
        double d = -2e-5d; //32 byte
        //endregion

        //region Символы
        char c = '\t'; //\u1234
        System.out.println(c);
        //endregion

        //region Логический
        boolean boo = true | false;
        //endregion

        System.out.println(0/0.);
        System.out.println(.1 + .2); //+ type overflow
    }
}
package demo.arraysdemo;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] arrayOfInt = //stack: 16-32 bit
            new int[10]; //heap & runtime = const
        //VS java.util.ArrayList | LinkedList

        for (int i = 0; i< arrayOfInt.length; i++) {
            System.out.println(arrayOfInt[i]); // 9 max
        }

        for (int current : arrayOfInt) {

        }

//        System.out.printlSn(arrayOfInt[10]);

        String[] stringArray = new String[10];
//        System.out.println(stringArray[0].toUpperCase());

        int[] literalArray = {1,2,3};
        m(new int[] {1,2,3});

        //region Multi
        int[][] matrix = new int[5][];
        matrix[0] = new int[5];
        matrix[1] = new int[3];
        //endregion
    }

    private static void m(int[] param) {

    }
}

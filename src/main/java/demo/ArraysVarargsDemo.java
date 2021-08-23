package demo;

public class ArraysVarargsDemo {
    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 1;
        System.out.println(array[1]);
//        array[-1] = 0;
        if (array.length == 0) {

        }
        for (int current : array) {

        }

        int[] literal = {1, 3, 6, 3, 2};

        int[][] matrix = new int[2][];
        matrix[0] = new int[5];
        matrix[1] = new int[3];

        m1(1,2,3);
        m1(1);
        m1(1,2);
        m1(0);

        m(new int[] {1,2,3});


        m1(0);


    }


    private static void m1(int... param) {
        System.out.println("11111");
    }

    private static void m1(int p) {
        System.out.println("3333");

    }



    private static void m(int[] arrParam) {
        arrParam[0] = 100;
        for (int current : arrParam) {
            System.out.println(current);
        }
    }


}

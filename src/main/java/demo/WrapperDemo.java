package demo;

public class WrapperDemo {
    public static void main(String[] args) {
        Integer i = 1; //auto! boxing
        Integer ii = new Integer(0);

        int iii = i; //auto! unboxing
        int iiii = i.intValue();


        Integer demo1 = 200;
        Integer demo2 = 2;
        System.out.println(demo1 == demo2);
    }
}

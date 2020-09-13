package demo;

public class WrapperDemo {
    public static void main(String[] args) {
        String s = "abc"; //
        Integer i = new Integer(1); // auto boxing
        Integer ii = 1;
        Integer iii = 1;
        System.out.println(i + "  " + ii + " " + iii);
        System.out.println(i == ii);
        System.out.println(ii == iii);

        Integer i1 = new Integer(iii); //127; //new In
        Integer i2 = 127;
        System.out.println(i1 == i2);

        Integer i3 = 9;
        int i4 = i3;
        i1.longValue();

        Integer.parseInt("123");
        Double.parseDouble("1.1");
        new Integer("123");
        new Double("1.1");

        System.out.println(i1 + i2);
        while (true) {
            i1++;
        }
    }
}

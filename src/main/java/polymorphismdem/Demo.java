package polymorphismdem;

public class Demo {
    public static void main(String[] args) {
        Object[] array = new Object[10];
        array[0] = "abc";
        array[1] = new Integer(2);
        for (Object current : array) {

            if (current instanceof String) {
                ((String)current).length(); //???
            }

            System.out.println(current.toString());
        }

        m("");
    }

    private static void m(Object param) {
        System.out.println(param.toString());
    }
}

package demo;

public class ReuseDemo {
    public static void main(String[] args) {
        m(0, Integer.MAX_VALUE, 1); //m1()
        m(0, Byte.MAX_VALUE, 2); //m2()
    }

    private static void m(int message, int maxValue, int codeTodo) {
        //.. 10 kSLoC
        //..
        if (message > maxValue) {

        }

        //doSmth

        if (codeTodo == 1) {

        } else if (codeTodo == 2) {

        } else {

        }
        //..
        //..
    }

    private static void m1(int message) {
        //...
        //...
        if (message > Integer.MAX_VALUE) {
            setField(mesasge)
        }

        //...
        //...
    }

    private static void m2(byte message) {
        //...
        //...
        if (message > Byte.MAX_VALUE) {
            setField(mesasge)
        }
        //...
        //...
    }

    setField(int )
    setField(byte )

}

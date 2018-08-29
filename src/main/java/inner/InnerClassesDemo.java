package inner;

import java.io.Serializable;

public class InnerClassesDemo {
    public static void main(String[] args) {
        System.out.println(getCommand().toString());
    }

    private static Object getCommand() {
        class My extends Object {
            @Override
            public String toString() {
                return "My";
            }
        }

        return new My();
    }
}

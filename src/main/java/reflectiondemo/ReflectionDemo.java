package reflectiondemo;

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("java.lang.String");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

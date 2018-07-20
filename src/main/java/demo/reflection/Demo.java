package demo.reflection;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //region Reflection:Introspection
        String className = "demo.reflection.Demo";
        Class classInfo = Class.forName(className);
        Object o = classInfo.newInstance();
        //endregion

        //region Virtual Proxy
        //Interface -> Implementation
        //endregion

        //region Byte-code instrumenting | manipulations
        //ByteBuddy | ASM
        //endregion
    }
}

class Empl {
    private int salary;

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

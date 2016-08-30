package syslibdemo;

import java.io.IOException;

public class SysLibDemo {
    public static void main(String[] args) throws IOException, InterruptedException, CloneNotSupportedException {
        Human m = new Human();
        Human m2 = m.clone();
    }
}

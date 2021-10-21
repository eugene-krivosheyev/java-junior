package output;

import java.util.ArrayList;

public class ConsoleOutput extends Output {
    public void send(String... strings) {
        for (String string : strings) {
            if (string != null) { System.out.println(string); }
        }
    }
}

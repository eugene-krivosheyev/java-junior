package output;

public class ConsolePrinter extends Printer {
    @Override
    public void print(String... strings) {
        for (String string : strings) {
            if (string != null) { System.out.println(string); }
        }
    }
}

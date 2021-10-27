package printer;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String... strings) {
        for (String string : strings) {
            if (string != null) {
                System.out.println(string);
            }
        }
    }
}

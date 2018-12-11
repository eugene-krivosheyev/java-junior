package demo.proceduraltoooad;

public class NewConsolePrinter extends ConsolePrinter {
    @Override
    public String print(String message) {
        System.out.println("super: ");
        super.print(message);
    }
}

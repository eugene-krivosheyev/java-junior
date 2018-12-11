package demo.proceduraltoooad;

public class NewConsolePrinter extends ConsolePrinter {
    @Override
    public void print(String message) {
        System.out.println("super: ");
        super.print(message);
    }
}

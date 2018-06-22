package demo.ooad;

public class ConsoleMessageSaver extends MessageSaver {
    private String message;

    public ConsoleMessageSaver(String message) {
        this.message = message;
    }

    public void save() {
        super.save(message);
        System.out.println(message);
    }
}

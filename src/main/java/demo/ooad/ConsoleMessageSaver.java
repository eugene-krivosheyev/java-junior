package demo.ooad;

public class ConsoleMessageSaver extends MessageSaver {
    @Override
    public void save(String message) {
        super.save(message);
        System.out.println(message);
    }
}

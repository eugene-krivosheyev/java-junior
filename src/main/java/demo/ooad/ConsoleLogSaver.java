package demo.ooad;

//IS-A
public class ConsoleLogSaver implements LogSaver {
    public void save(String message) {
        System.out.println(message);
    }
}

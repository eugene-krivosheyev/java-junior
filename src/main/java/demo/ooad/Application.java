package demo.ooad;

public class Application {
    public static void main(String[] args) {
        //DI Frameworks: Spring, Google Juice
        Logger logger = new Logger(
            new MessageLengthLogFilter(10)
        );
    }
}

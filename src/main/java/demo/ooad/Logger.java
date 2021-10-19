package demo.ooad;

public class Logger {
    private Saver saver = new FileSaver("operations.log"); // [GRASP] Creator
    private Filter filter = new HardcodedFilterFactory().get(); // [GoF] Abstract Factory -> Registry

    /**
     * 1 MSLoC
     * @param DTO | Command
     */
    public void log(Message message) {
        if (!filter.filter(message)) { // [GoF]: Visitor
            saver.save(message.getBody());
        }
    }
}

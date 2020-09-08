package refactoring.save;

import refactoring.message.Message;

public class ConsoleSaver implements Saver {
    @Override
    public void save(Message message) {
        System.out.println(message);
    }
}

package demo.ooad;

public class StubSaverFactory implements SaverFactory {
    @Override
    public MessageSaver createSaverWithState() {
        return new MessageSaver();
    }
}

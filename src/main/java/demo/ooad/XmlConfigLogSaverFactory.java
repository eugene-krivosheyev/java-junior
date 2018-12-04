package demo.ooad;

public class XmlConfigLogSaverFactory implements SaverFactory {
    @Override
    public LogSaver createLogSaver() {
        return new ConsoleLogSaver();
    }
}

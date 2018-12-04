package demo.ooad;

public class Registry {
    public static SaverFactory createLogSaverFactory() {
        return new XmlConfigLogSaverFactory();
    }
}

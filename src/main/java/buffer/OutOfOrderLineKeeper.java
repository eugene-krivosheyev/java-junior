package buffer;

import java.util.ArrayList;

public class OutOfOrderLineKeeper {
    private ArrayList<String> extraOrdinary = new ArrayList<>();
    private final String prefix;

    public OutOfOrderLineKeeper(String prefix) {
        this.prefix = prefix;
    }

    public void add(String string) {
        extraOrdinary.add(prefix + string);
    }

    public ArrayList<String> getExtraordinaryBody() {
        if (extraOrdinary.isEmpty()) {
            return null;
        } else {
            ArrayList<String> result = new ArrayList<>(extraOrdinary);
            extraOrdinary.clear();
            return result;
        }
    }
}

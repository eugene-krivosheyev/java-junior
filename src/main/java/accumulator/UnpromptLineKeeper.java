package accumulator;

import java.io.Serializable;
import java.util.ArrayList;

public class UnpromptLineKeeper implements Serializable {
    final private ArrayList<String> buffer = new ArrayList<>();
    private final String prefix;

    public UnpromptLineKeeper(String prefix) {
        this.prefix = prefix;
    }

    public void add(String string) {
        buffer.add(prefix + string);
    }

    public String[] extract() {
        if (buffer.isEmpty()) {
            return null;
        } else {
            ArrayList<String> result = buffer;
            String[] array = new String[result.size()];
            result.toArray(array);
            buffer.clear();
            return array;
        }
    }
}

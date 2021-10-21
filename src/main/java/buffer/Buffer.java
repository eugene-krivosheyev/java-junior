package buffer;

import message.Message;

import java.util.ArrayList;
import java.util.Objects;

public class Buffer {

    protected ArrayList<String> extraOrdinary = new ArrayList<>();
    protected String prefix;

    public boolean isNewBufferType (Class<?> c1, Class<?> c2) {
        String name1 = c1.getCanonicalName();
        String name2 = c2.getCanonicalName();
        return Objects.equals(name1, name2);
    }

    public String getBody() {
        return null;
    }

    public ArrayList<String> getExtraordinaryBody() {
        if (extraOrdinary.isEmpty()) {
            return null;
        } else {
            ArrayList<String> result = new ArrayList<>();
            for (String string : extraOrdinary) {
                result.add(prefix + string);
            }
            extraOrdinary.clear();
            return result;
        }
    }

    public void accumulate(Message message) {
        return;
    }
}

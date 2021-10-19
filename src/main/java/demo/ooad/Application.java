package demo.ooad;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        //region [GoF] Factory Method
        Arrays.asList(1,2,3);
        Set.of(1,2,3);
        Optional.of("value");
        String.valueOf(1);
        Integer.valueOf(1);
        //endregion
    }
}

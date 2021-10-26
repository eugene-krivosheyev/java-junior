package demo.ooad;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

public class Application {
    public static void main(final String[] args) {
        //region [GoF] Factory Method Demo
        Arrays.asList(1,2,3);
        Set.of(1,2,3);
        Optional.of("value");
        String.valueOf(1);
        Integer.valueOf(1);
        //endregion

        //region Create objects and link
        //Hand-written Builder:
        final LoggerController logger = new LoggerController(
                new FileSaver("operations.log"),
                new HardcodedFilterFactory().get()
        );

        // IoC
        //Reusable DI framework: Spring Core
//        AppContext ctx = new XmlClasspathApplicationContext("config.xml");
//        Logger logger = ctx.getBean(Logger.class);
        //endregion

        //region Request handling: Spring MVC
//        while (true) {
//            HttpRequest request = getHttpRequest();
//            switch (request) {
//                case "/endpoint": Response response = logger.log(...);
//            }
//            sendHttpResponse(response);
    }
        //endregion
}

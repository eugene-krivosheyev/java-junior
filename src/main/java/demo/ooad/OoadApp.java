package demo.ooad;

import demo.ooad.controller.LoggerController;
import demo.ooad.filter.ContentFilter;
import demo.ooad.dao.FileSaver;
import demo.ooad.validator.EmptynessValidator;

public class OoadApp {
    public static void main(String[] args) {
        //region App Builder -> App Context
        LoggerController controller = new LoggerController(
                new ContentFilter("volandemort", new EmptynessValidator()),
                new FileSaver("log.txt")
        );
        //endregion

        /*
        //region Spring Core: DI framework + AOP
        ApplicationContext ctx = new ApplicationContext("config.json");
        LoggerController controller = ctx.getBean(LoggerController);
        //endregion

        //region Spring MVC over HTTP
        while (true) {
            Request rq = waitForRequest(); //remoting
            switch (rq.getAddress()) {
                case "/log": controller.log(rq.getMessage()); break;
            }
            sendResponse();
        }
        //endregion
         */
    }
}

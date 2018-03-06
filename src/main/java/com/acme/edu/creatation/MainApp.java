package com.acme.edu.creatation;

import com.acme.edu.refactoring.Controller;

public class MainApp {
    public static void main(String[] args) {
       Controller controller =
               new SpringContext("config.xml")
                .getBean("controller");

       // VS

        LoggerController controller =
                new LoggerController(
                        new FileSaver(
                                "out.log"
                        )
                );

        controller.log();
        controller.log();
        controller.log();
        controller.log();
        controller.log();
    }
}

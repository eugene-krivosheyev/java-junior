package net;

import controller.Controller;
import printer.ConsolePrinter;

public class Server {
    public static void main(String... args) {

        final Controller controller = new Controller(new ConsolePrinter());
        final Skeleton skeleton = new Skeleton();

        while(true) {
            controller.log(skeleton.receive());
        }
    }
}

package com.acme.edu.syslib;

import java.io.File;
import java.io.IOException;
import java.lang.*;
import java.util.Date;

import static java.lang.System.exit;

public class SyslibDemo {
    public static void main(String[] args) {
        System.exit(0);
        System.getProperties().get("path.separator");
        System.gc(); //
//        System.arraycopy();
        ; //epoc: 1.1.70
        new Date(System.currentTimeMillis());
        System.nanoTime();

        System.load("my-lib.dll"); //JNI -> JNA

        try {
            Runtime.getRuntime().exec("my.bat");
        } catch (IOException e) {
            e.printStackTrace();
        }


        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                super.run();
            }
        });



    }
}

class My {
    public native void m();
}

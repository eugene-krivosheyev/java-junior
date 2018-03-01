package com.acme.edu.ooad;

public class ConsoleSaver extends CommonBehaviorSaver {
    @Override
    public void save(String message) {
        if (isEmpty(message)) return;
        System.out.println(message);
    }
}

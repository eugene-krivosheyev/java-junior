package com.acme.edu.demo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Component
public class EncapsulationDemo {
    @Inject private Saver saver;

}

class Base {
    @Nullable private Integer i;

    void save() {
        i.intValue();
        System.out.println(i);
    }
}

class Sub extends Base {
    @Override
    void save() {
        super.save();
    }
}

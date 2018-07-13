package demo.javabeans;

import java.io.Serializable;

public class Demo {

}

/**
 * POJO: set/get -> properties
 */
class MyComponent implements Serializable {
    private String label;

    public MyComponent() {
    }

    public MyComponent(String label) {
        this.label = label;
    }

    /**
     * Property
     */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

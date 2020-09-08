package demo.reuse;

public abstract class TemplateMethod {
    public void log1() {
        System.out.println("begin");
        //?????
        System.out.println("end");
    }

    public void log2() {
        System.out.println("begin");
        //?????
        System.out.println("end");
    }

    //-----------------

    public void log() {
        System.out.println("begin");
        step();
        System.out.println("end");
    }

    protected abstract void step();
}

class StepImplementation1 extends TemplateMethod {
    @Override
    protected void step() {
        System.out.println("custom impl 1");
    }
}

class StepImplementation2 extends TemplateMethod {
    @Override
    protected void step() {
        System.out.println("custom impl 2");
    }
}
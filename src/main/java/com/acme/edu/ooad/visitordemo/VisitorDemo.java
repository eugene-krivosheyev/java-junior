package com.acme.edu.ooad.visitordemo;

public class VisitorDemo {
    public static void main(String[] args) {
        Visitable dataStructure = new IntMessage();
        dataStructure.accept(new CummulativeVisitor());
    }
}

interface Visitable {
    void accept(Visitor visitor);
}

class IntMessage implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitA(this);
    }
}

class StringMessage implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitB(this);
    }
}

interface Visitor {
    void visitA(IntMessage visitable);
    void visitB(StringMessage visitable);
}

class SimpleVisitor implements Visitor {
    @Override
    public void visitA(IntMessage visitable) {

    }

    @Override
    public void visitB(StringMessage visitable) {

    }
}

class CummulativeVisitor implements Visitor {
    @Override
    public void visitA(IntMessage visitable) {

    }

    @Override
    public void visitB(StringMessage visitable) {

    }
}
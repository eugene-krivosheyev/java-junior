package com.acme.edu.primitives;

public class StackDemo {
    public static void main(String[] args) {
        int param = 0;
        f(param); //Factual
        System.out.println(param);

        Employee ek = new Employee("EK");
        f2(ek);
        System.out.println(ek.getName());
    }

    private static void f2(Employee ek) {
        ek.setName("Molodets!!!!");
    }

    private static void f(int param) { //Formal
        param = 1;
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

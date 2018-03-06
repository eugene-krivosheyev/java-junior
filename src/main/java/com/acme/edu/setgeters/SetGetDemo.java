package com.acme.edu.setgeters;

public class SetGetDemo {
    public static void main(String[] args) {
        System.out.println(new Employee().salary);
        System.out.println(new BigBoss().getSalary());
    }
}

class Employee {
    private int salary = 10_000;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

class BigBoss extends Employee {

}

class Girl {
    private int age;


    public int getAge() {
        return 18;
    }
}

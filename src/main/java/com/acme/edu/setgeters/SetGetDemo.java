package com.acme.edu.setgeters;

public class SetGetDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.getSalary();
        employee.getSalary();
        employee.getSalary();
        employee.getSalary();
        employee.getSalary();
        employee.getSalary();
        employee.getSalary();
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

class NewEmployee extends Employee {
    @Override
    public int getSalary() {
        return super.getSalary() + 10_000_000;
    }
}

class Girl {
    private int age;


    public int getAge() {
        return 18;
    }
}

package com.acme.edu.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        /*
        Employee ee = EmployeeFactory.create();
        Employee e = EmployeeBuilder
                .withName()
                .withSalary()
                .withCompany(
                        CompanyBuilder
                            .withName()
                        .build()
                )
            .build();
        */
    }
}

class Employee {
    private String name;
    private int salary;
//    private Company company;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
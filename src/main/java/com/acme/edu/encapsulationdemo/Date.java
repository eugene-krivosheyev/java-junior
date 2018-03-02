package com.acme.edu.encapsulationdemo;

public class Date {
    int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) { //Property
        if (month < 1 || month > 31) return;
        this.month = month;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) return;
        this.day = day;
    }

     int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}

class IndishDate extends Date {
    @Override
    protected int getYear() {
        return 0; //super.getYear(); + 10_000;
    }

    public int getEpoc() {
        return 15;
    }
}

class DateDemo {
    public static void main(String[] args) {
        Date date = ???; //new IndishDate();
        date.getYear();
    }
}


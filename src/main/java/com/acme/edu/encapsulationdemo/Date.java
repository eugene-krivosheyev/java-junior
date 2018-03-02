package com.acme.edu.encapsulationdemo;

public class Date {
    int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        super();
        setDay(day);
        setMonth(month);
        setYear(year);
        System.out.println("bc1");
    }

    public Date(int year) {
        this(year,1, 1);
        System.out.println("bc2");
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
    private int state;

    {
        System.out.println("ib");
        this.state = 0;
    }

    public IndishDate(int year, int state) {
        super(year);
        ///<<<<============ ib
        System.out.println("c1");
        this.state = state;
    }

    public IndishDate(int year, int month, int day, int state) {
        super(year, month, day);
        System.out.println("c2");
        this.state = state;
    }

    @Override
    protected int getYear() {
        return 0; //super.getYear(); + 10_000;
    }

    public int getEpoc() {
        return 15;
    }

    public int getState() {
        return state;
    }
}

class DateDemo {
    public static void main(String[] args) {
        Date date = new IndishDate(1,1); //new IndishDate();
    }
}


package demo.ooad;

//Default || package-friendly:
//[GoF] Template Method
abstract class MessageLogFilter extends LoggerFilter {
    @Override
    //REUSE!!!!!
    public final boolean filter(String message, int severity) {
        if (message != null) {
            return checkMessageLength(message);
        } else {
            return false;
        }
    }

    protected abstract boolean checkMessageLength(String message);
}

class MessageLengthLogFilter extends MessageLogFilter {
    private int maxLength;

    MessageLengthLogFilter() {
        this(0);
    }

    MessageLengthLogFilter(int maxLength) {
        if (maxLength == 0) throw new IllegalArgumentException();
        this.maxLength = maxLength;
    }

    @Override
    public boolean checkMessageLength(String message) {
        return message.length() > maxLength;
    }
}

class MyDate {
    //Data hiding
    private int year; //Constraints
    private int mo; //Constr
    private int day; //Con

    public int getYear() {
        return year;
    }

    //Property: set + get
    public void setYear(int year) {
        this.year = year;
    }

    public int getMo() {
        return mo;
    }

    public void setMo(int mo) {
        this.mo = mo;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

class Woman {
    private int age;

    public int getAge() {
        return 18;
    }
}

class Man {
    private int beardSize;

    public int getBeardSize() {
        return beardSize*2;
    }
}

//OCP: incapsulate early
class Cat {
    public String name;


}

class SuperCat extends Cat {
    public String name;
}


package com.acme.edu.demo;

public class TemplateMethodDemo {
    public static void main(String[] args) {

    }
}

/**
 * Template Method
 */
abstract class JdbcTemplate {
    public void doRequest() {
        //...
        this.request(); //step!
        //...
    }

    protected abstract void request();
}

class MyRequestJdbcTemplate extends JdbcTemplate {
    @Override
    protected void request() {
       //?????
    }
}

package com.acme.edu;


strictfp class DemoClientForNamespace {
    public static void main(String[] args) {
        m("");
        m("", "");
        m("", "", "");
    }

    static void m(String a) {
        System.out.println(">>>>>" + a);
    }

    static void m(String... param) {
        for (String element : param) {
            System.out.println(element);
        }
    }

}
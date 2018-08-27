package com.acme.edu.saver;

public class ConsoleSaver extends Saver {
    @Override
    public void save(String message) throws Exception {
        super.save(message);
        System.out.println(message);
    }
    /*public static void main(String[] args) {
        Saver saver = new ConsoleSaver();
        try {
            saver.save(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/
}

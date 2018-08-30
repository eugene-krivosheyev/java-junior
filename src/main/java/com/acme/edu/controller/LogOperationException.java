package com.acme.edu.controller;

/**
 * Created by Java_1 on 30.08.2018.
 */
 public class LogOperationException extends Exception {

     private int code;

     public LogOperationException(String message, int code) {
         super(message);
         this.code = code;
    }


    public LogOperationException(Throwable cause) {
         super(cause);
    }


   public LogOperationException(String message, Throwable cause, int code) {
         super(message, cause);
         this.code = code;
    }

    public int getCode() {
         return code;
    }
 }

package com.acme.edu.saver;

/**
 * Created by Java_1 on 30.08.2018.
 */
public class SaveException extends Exception {
    private int code = 0;
    public SaveException(int code) {
         super();
         this.code = code;
    }

   public SaveException(String message, int code) {
        super(message);
        this.code = code;
     }

    public SaveException(String message, Throwable cause) {
          super(message, cause);
    }

    public SaveException(Throwable cause) {
       super(cause);
     }

    protected SaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
         super(message, cause, enableSuppression, writableStackTrace);
      }

}
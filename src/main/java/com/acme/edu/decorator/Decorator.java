package com.acme.edu.decorator;

public abstract class Decorator {
   public abstract String decorate(int message);
   public abstract String decorate(String message);
   public abstract String decorate(byte message);
   public abstract String decorate(char message);
   public abstract String decorate(boolean message);
}

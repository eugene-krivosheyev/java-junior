package com.acme.edu;

public class ClassValidator {
    private Class<?> currentClass = null;

    public ClassValidator() {}

    public boolean setCurrentClass(Object object) {
        if(this.currentClass != object.getClass()){
            this.currentClass = object.getClass();
            return false;
        }

        return true;
    }

    public boolean checkValidatorIsNull(){
        return currentClass == null;
    }

    public void clearClass(){
        this.currentClass = null;
    }
}

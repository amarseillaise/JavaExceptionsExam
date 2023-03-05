package org.example.myExceptions;

public class SexNotFoundException extends RuntimeException {
    public SexNotFoundException(){

        super("A sex is not entered or entered incorrect");
    }
}

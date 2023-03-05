package org.example.myExceptions;

public class NumberNotFoundException extends RuntimeException{
    public NumberNotFoundException(){

        super("Вы не ввели номер телефона");
    }
}

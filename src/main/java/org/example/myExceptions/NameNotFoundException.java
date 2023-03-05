package org.example.myExceptions;

public class NameNotFoundException extends RuntimeException {
    public NameNotFoundException(){
        super("Вы не ввели имя или программа не смогла его распознать, введите другое имя)");
    }
}

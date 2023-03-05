package org.example.myExceptions;

public class SurnameNotFoundException extends RuntimeException {
    public SurnameNotFoundException(){

        super("Вы не ввели фамилию или программа не смогла её распознать, введите другую фамилию)");
    }
}

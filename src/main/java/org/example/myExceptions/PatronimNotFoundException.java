package org.example.myExceptions;

public class PatronimNotFoundException extends RuntimeException{
    public PatronimNotFoundException(){

        super("Вы не ввели отчество или программа не смогла его распознать, введите другое отчетсво)");
    }
}

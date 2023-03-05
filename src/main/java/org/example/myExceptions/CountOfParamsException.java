package org.example.myExceptions;

public class CountOfParamsException extends RuntimeException{
    public CountOfParamsException(){
        super("Вы ввели больше или меньше данных, чем необходимо");
    }
}

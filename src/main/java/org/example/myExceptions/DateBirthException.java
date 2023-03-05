package org.example.myExceptions;

public class DateBirthException extends RuntimeException {
    public DateBirthException(){

        super("Вы не ввели дату рождения, либо ввели, но некорректно. Формат даты - дд.мм.гггг");
    }
}

package org.example;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main (String[] args) {
        System.out.println("""
                Введите следующие данные в одну строку, в произвольном порядке, разделенные пробелом:
                фамилию, имя, отчество;
                дату рождения в формате дд.мм.гггг;
                Номер телефона в формате 89150123456
                Пол латиницей f или m""");

        Scanner scanner = new Scanner(System.in);
        CheckString check = new CheckString();

        String[] input = scanner.nextLine().split(" ");
        if (check.checkString(input)) System.out.println("Да");
        else System.out.println("Нет");
    }
}
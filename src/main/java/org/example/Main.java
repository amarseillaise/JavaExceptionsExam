package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.println("""
                Введите следующие данные в одну строку, в произвольном порядке, разделенные пробелом:
                фамилию, имя, отчество;
                дату рождения в формате дд.мм.гггг;
                Номер телефона в формате 89150123456
                Пол латиницей f или m""");

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> dataset = new HandlerString(scanner.nextLine().split(" ")).getOrderString();
        new WriterToFile(dataset);
    }
}
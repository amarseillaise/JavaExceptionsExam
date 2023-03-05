package org.example;

import org.example.myExceptions.*;

import java.util.ArrayList;
import java.util.List;

public class HandlerString {
    private final String[] data;
    private String name;
    private String surname;
    private String patronim;
    private String dateBirth;
    private String number;
    private String sex;
    private ArrayList<Object> detectedElements = new ArrayList<>();

    public HandlerString(String[] data){
        this.data = data;
    }

    public ArrayList<String> getOrderString(){
        if (data.length != 6) throw new CountOfParamsException();
        findSex();
        findDateBirth();
        findNumber();
        findSurname();
        findPatronim();
        findName();
        return new ArrayList<>(List.of(this.surname, this.name, this.patronim, this.dateBirth, this.sex, this.number));
    }

    private void findSex(){
        for (String str: data
             ) {
            if (str.length() == 1 && (str.equals("m") || str.equals("f")))  this.sex = str;
        }
        if (this.sex == null) throw new SexNotFoundException();
        detectedElements.add(this.sex);
    }

    private void findDateBirth(){
        for (String str: data
             ) {
            if (str.length() > 3){
                if (Character.hashCode(str.charAt(2)) == Character.hashCode('.')) this.dateBirth = str;
            }
        }
        if (this.dateBirth == null) throw new DateBirthException();
        detectedElements.add(this.dateBirth);
    }

    private void findNumber(){
        for (String str: data
             ) {
            if (Character.hashCode(str.charAt(0)) == Character.hashCode('8')) this.number = str;
        }
        if (this.number == null) throw new NumberNotFoundException();
        detectedElements.add(this.number);
    }

    private void findSurname(){
        ArrayList<String> surnameSuffix = new ArrayList<>(List.of("ов", "ев", "ёв", "ин", "ын", "их", "ых", "ий", "ой", "ый", "зе", "ли", "ян", "ко", "ец", "ва", "на", "ая"));
        ArrayList<Integer> wrongPreSuffixHashList = new ArrayList<>(List.of(Character.hashCode('в'), Character.hashCode('ч'), Character.hashCode('ш')));

        for (String str: data
             ) {
            if (str.length() > 3){
                String suffix = Character.toString(str.charAt(str.length() - 2))  + Character.toString(str.charAt(str.length() - 1));
                Integer preSuffixHash = Character.hashCode(str.charAt(str.length() - 3));
                if (sex.equals("m")){
                    if (surnameSuffix.contains(suffix)) this.surname = str;
                }
                if (sex.equals("f")){
                    if (surnameSuffix.contains(suffix) && !wrongPreSuffixHashList.contains(preSuffixHash)) this.surname = str;
                }

            }
        }
        if (this.surname == null) throw new SurnameNotFoundException();
        detectedElements.add(this.surname);
    }

    private void findPatronim(){
        ArrayList<String> patronimSuffix = new ArrayList<>(List.of("вич", "вна", "чна", "шна"));

        for (String str: data
        ) {
            if (str.length() > 3){
                String suffix = Character.toString(str.charAt(str.length() - 3)) + Character.toString(str.charAt(str.length() - 2)) + Character.toString(str.charAt(str.length() - 1));
                if (patronimSuffix.contains(suffix)) this.patronim = str;
            }
        }
        if (this.patronim == null || this.patronim.equals(this.surname)) throw new PatronimNotFoundException();
        detectedElements.add(this.patronim);
    }

    private void findName(){
        for (String str: data
             ) {
            if (!detectedElements.contains(str)) this.name = str;
        }
        if (this.name == null) throw new NameNotFoundException();
    }
}

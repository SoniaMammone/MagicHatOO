package org.generation.italy.magicHatOO.model;

import java.util.Random;

public class Student {
    private String name;
    private String lastname;
    private House favHouse;
    private Random random;

    public Student(String name, String lastname, House faHouse){
        this.name = name;
        this.lastname = lastname;
        this.favHouse = faHouse;
        this.random = new Random();
    }

    public Student(String name, String lastname){
        this(name, lastname, null);
    }

    public String getFullName() {
        return String.format("%s %s", name, lastname);
    }

    public boolean hasFavHouse(){
        return favHouse != null;
    }

    public House getFavHous(){
        return favHouse;
    }

    public boolean isLucky() {

        //entrambi i metodi fanno la stessa cosa, uno in maniera ridotta l'altra in maniera estesa
        return random.nextInt(2) == 0;

        /*int result = random.nextInt(2);
        if (result == 0){
            return true;
        } else{
            return false;
        }*/
    }

}

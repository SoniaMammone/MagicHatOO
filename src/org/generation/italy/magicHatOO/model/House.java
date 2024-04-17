package org.generation.italy.magicHatOO.model;

import java.util.ArrayList;
import java.util.Random;

public enum House {
    //oggetti statici
    GRYFFINDOR, HUFFLEPUFF, SLYTHERIN, RAVENCLAW;
    private ArrayList <Student> members = new ArrayList<>();
    public static final int STANDARD_DIMENSION = 10;    
    private int dimension = STANDARD_DIMENSION;
    private static Random random = new Random(); // anche questo va messo static altrimenti il metodo non lo vede

    /*House(){
        this.dimension = 7;
    }*/

    //metodo statico perchè chiedo alla classe di darmi una classe in modo randomico
    public static House getRandomHouse(){
        int pos = random.nextInt(House.values().length); //stiamo prendendo la lunghezza delle case della classe enum, ossia 4
        return House.values()[pos];
        //values torna un array di tutte le enum in posizione come sono stati inseriti
    }

    //aggiungere studenti alla casa che non arrivi alla dimensione max
    public boolean addStudent(Student s){
        if (isFull()){
            return false;
        }
        members.add(s);
        return true;
    }

    public boolean isFull(){
        return members.size() >= dimension;
    }

    public void setDimension(int d){
        dimension = d;
    }

    public static void assignSize(int standardSize) {
        for(int i = 0; i < House.values().length; i++){
            House h = House.values()[i];
            h.setDimension(standardSize);
        }
    }

    public Student get(int pos){
        if(pos >= members.size()){
            return null;
        }
        return members.get(pos);
    }

    public String getName(int pos){
        Student s = get(pos);
        return s != null ? s.getFullName() : " ";
    }
}
